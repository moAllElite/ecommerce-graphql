package com.groupeisi.ecommercegraphql.mappers.impl;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.dto.ValidationDto;
import com.groupeisi.ecommercegraphql.entities.User;
import com.groupeisi.ecommercegraphql.entities.Validation;
import com.groupeisi.ecommercegraphql.mappers.UserMapper;
import com.groupeisi.ecommercegraphql.mappers.ValidationMapper;
import com.groupeisi.ecommercegraphql.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@Component
public class ValidationMapperImpl implements ValidationMapper {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public Validation toValidationEntity(ValidationDto validationDto) {
        Validation validation = new Validation();
        validation.setCode(validationDto.getCode());
        validation.setExpiration(validationDto.getExpiration());
        User userExist =  userRepository.findById(validationDto.getUserId()).orElseThrow(
                ()-> new EntityNotFoundException("User not found with id: "+validationDto.getUserId())
        );
        validation.setUser(userExist);
        validation.setCreation(validationDto.getCreation());
        validation.setActivation(validationDto.getCreation());
        return validation;
    }

    @Override
    public ValidationDto toValidationDto(Validation validation) {
        ValidationDto  validationDto = new ValidationDto();
        validationDto.setCode(validation.getCode());
        validationDto.setExpiration(validation.getExpiration());
        validationDto.setCreation(validation.getCreation());
        UserDto userDto = userMapper.toUserDto(validation.getUser());
        validationDto.setUserId(userDto.getId());
        return validationDto;
    }



}
