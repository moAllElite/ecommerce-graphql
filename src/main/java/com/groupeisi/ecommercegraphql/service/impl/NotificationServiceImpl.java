package com.groupeisi.ecommercegraphql.service.impl;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.dto.ValidationDto;
import com.groupeisi.ecommercegraphql.mappers.UserMapper;
import com.groupeisi.ecommercegraphql.repository.UserRepository;
import com.groupeisi.ecommercegraphql.service.INotificationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements INotificationService {
    final JavaMailSender  javaMailSender;
    private final UserRepository userRepository;
    private final UserMapper  userMapper;
    /**
     * @param validationDto  is a Data Transfer object that contains the data to be sent to the notification service.
     */
    @Override
    public void sendNotification(ValidationDto validationDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        Long idUser = validationDto.getUserId();
        UserDto userDto  = userRepository.findById(idUser)
                .map(userMapper::toUserDto)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Utilisateur avec l'id: %s est introuvable",idUser)));
        message.setTo(userDto.getEmail());
        message.setFrom("no-replymouhamedniang@groupeisi.com ");
        message.setSubject("Votre code d'activiation");
        String texte= String.format(
                " Bonjour <br/> %s Votre code d'activation est : <b>%s",
                userDto.getNom(),
                validationDto.getCode()
        );
        message.setText(texte);
        javaMailSender.send(message);
    }
}
