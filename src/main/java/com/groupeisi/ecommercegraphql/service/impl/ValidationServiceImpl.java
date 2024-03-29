package com.groupeisi.ecommercegraphql.service.impl;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.dto.ValidationDto;
import com.groupeisi.ecommercegraphql.mappers.ValidationMapper;
import com.groupeisi.ecommercegraphql.repository.ValidationRepository;
import com.groupeisi.ecommercegraphql.service.INotificationService;
import com.groupeisi.ecommercegraphql.service.ValidationService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@AllArgsConstructor
@Service
public class ValidationServiceImpl implements ValidationService {
    private final ValidationRepository validationRepository;
    private final   ValidationMapper validationMapper;
    private final   INotificationService  notificationService;
    private static final Integer EXPIRATION_TIME = 10;
    private static final Random  random = new Random();
    @Override
    public void saveValidate(UserDto userDto) throws MessagingException {

        ValidationDto validationDto = new ValidationDto();
        validationDto.setUserId(userDto.getId());
        Instant creation= Instant.now();
        validationDto.setCreation(creation);

        Instant expiration= creation.plus(EXPIRATION_TIME, ChronoUnit.MINUTES);
        validationDto.setExpiration(expiration);

        int intRandom = random.nextInt(999999);
        String code = String.format("%06d", random.nextInt(intRandom));

        validationDto.setCode(code);

        this.validationRepository.save(
                validationMapper.toValidationEntity(validationDto)
        );
        //SEND email notification with code to user
        this.notificationService.sendNotification(validationDto);
    }

    /**
     * @param code is a concatenation  of six number randomly generate
     * @return ValidationDto
     */
    @Override
    public ValidationDto getValidationByCode(String code) {
        return validationRepository.findByCode(code)
                .map(validationMapper::toValidationDto)
                .orElseThrow(
                        () -> new IllegalArgumentException("Votre code d'activation est invalide ! ")
                );
    }


}
