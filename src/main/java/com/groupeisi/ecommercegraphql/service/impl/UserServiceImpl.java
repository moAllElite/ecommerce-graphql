package com.groupeisi.ecommercegraphql.service.impl;

import com.groupeisi.ecommercegraphql.dto.RoleDto;
import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.TypeDeRole;
import com.groupeisi.ecommercegraphql.entities.User;
import com.groupeisi.ecommercegraphql.mappers.UserMapper;
import com.groupeisi.ecommercegraphql.repository.UserRepository;
import com.groupeisi.ecommercegraphql.service.IUserService;
import com.groupeisi.ecommercegraphql.service.ValidationService;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private static final String EMAILREGEX= "^(.+)@(.+)$";
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ValidationService validationService;
    @Override
    public void save(UserDto userDto) {
        // vérifie si le mail est invalide
        if(!userDto.getEmail().matches(EMAILREGEX)) {
            throw  new IllegalArgumentException(
                    "Email fourni est  invalide"
            );
        }
        // vérifie si l'email existe
        Optional<UserDto> userExist = userRepository
                .findByEmail(userDto.getEmail())
                .map(userMapper::toUserDto);

        if(userExist.isPresent()){
            throw new EntityExistsException(
                    String.format("Email %s est déjà pourvu ",userDto.getEmail())
            );
        }
        // crypter le mot de passe
        String pwdBcrypt = this.passwordEncoder.encode(userDto.getPassword());

        //assigned a role
        RoleDto savedRole = new RoleDto();
        savedRole.setLibelle(TypeDeRole.USER);

        userDto.setPassword(pwdBcrypt);
        userDto.setRoleDto(savedRole);

        User user   =   this.userRepository.save(userMapper.toUserEntity(userDto));

        validationService.saveValidate(userMapper.toUserDto(user));

    }


    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toUserDto);
    }
}
