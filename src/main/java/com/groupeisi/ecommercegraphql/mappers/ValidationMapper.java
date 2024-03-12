package com.groupeisi.ecommercegraphql.mappers;

import com.groupeisi.ecommercegraphql.dto.ValidationDto;
import com.groupeisi.ecommercegraphql.entities.Validation;

public interface ValidationMapper {
    Validation toValidationEntity(ValidationDto validationDto);
    ValidationDto toValidationDto(Validation validation);
}
