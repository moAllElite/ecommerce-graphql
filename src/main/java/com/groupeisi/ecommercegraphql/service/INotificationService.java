package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.ValidationDto;

public interface INotificationService {
    void sendNotification(ValidationDto validationDto);
}
