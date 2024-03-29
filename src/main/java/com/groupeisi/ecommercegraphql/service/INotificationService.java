package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.ValidationDto;
import jakarta.mail.MessagingException;

public interface INotificationService {
    void sendNotification(ValidationDto validationDto) throws MessagingException;
}
