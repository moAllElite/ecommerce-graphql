package com.groupeisi.ecommercegraphql.service.impl;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.dto.ValidationDto;
import com.groupeisi.ecommercegraphql.mappers.UserMapper;
import com.groupeisi.ecommercegraphql.repository.UserRepository;
import com.groupeisi.ecommercegraphql.service.INotificationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements INotificationService {
    final JavaMailSender  javaMailSender;
    private final UserRepository userRepository;
    private final UserMapper  userMapper;
    private final MailView  mailView;
    private static final String LINK = "http:localhost:8080/activation";

    /**
     * @param validationDto  is a Data Transfer object that contains the data to be sent to the notification service.
     */
    @Override
    public void sendNotification(ValidationDto validationDto) throws MessagingException {
        Long idUser = validationDto.getUserId();
        UserDto userDto  = userRepository.findById(idUser)
                .map(userMapper::toUserDto)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Utilisateur avec l'id: %s est introuvable",idUser)));

        MimeMessage message= javaMailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(message, true);

        helper.setTo(userDto.getEmail());
        helper.setFrom("mouhamedn347@gmail.com");
        helper.setSubject("Votre code d'activation");
        String htmlView = mailView.mailView(userDto.getNom(),validationDto.getCode(),LINK);
        helper.setReplyTo("no-reply-mouhamedn347@gmail.com");
        helper.setText(htmlView,true);

        javaMailSender.send(message);
    }
}
