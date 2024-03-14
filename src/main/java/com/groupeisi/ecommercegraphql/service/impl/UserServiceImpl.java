package com.groupeisi.ecommercegraphql.service.impl;

import com.groupeisi.ecommercegraphql.dto.RoleDto;
import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.dto.ValidationDto;
import com.groupeisi.ecommercegraphql.entities.TypeDeRole;
import com.groupeisi.ecommercegraphql.entities.User;
import com.groupeisi.ecommercegraphql.mappers.RoleMapper;
import com.groupeisi.ecommercegraphql.mappers.UserMapper;
import com.groupeisi.ecommercegraphql.repository.UserRepository;
import com.groupeisi.ecommercegraphql.service.IUserService;
import com.groupeisi.ecommercegraphql.service.ValidationService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private static final String EMAILREGEX= "^(.+)@(.+)$";
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final ValidationService validationService;
    @Override
    public Long save(TypeDeRole roleLibelle,UserDto userDto) {
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
          throw new EntityExistsException("Email  déjà attribué à un utilsateur");
        }
        // crypter le mot de passe
        String pwdBcrypt = this.passwordEncoder.encode(userDto.getPassword());

        userDto.setPassword(pwdBcrypt);
        //ASSIGNE ROLE TO user
        RoleDto roleDto = new RoleDto();
        roleDto.setLibelle(roleLibelle);
        User   obtainUser = userMapper.toUserEntity(userDto);
        obtainUser.setRole(roleMapper.toRoleEntity(roleDto));
        User user  =  this.userRepository.save(obtainUser);
        validationService.saveValidate(userMapper.toUserDto(user));
        return user.getId();
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

    /**
     * @param id as Long
     * @return Optional<UserDto>
     */
    @Override
    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserDto);
    }



    /**
     * @param activation Map<String,String>
     */
    @Override
    public void activation(Map<String, String> activation) {
        ValidationDto validationDto = this.validationService.getValidationByCode(activation.get("code"));
        if(Instant.now().isAfter(validationDto.getExpiration())) {
            throw new IllegalArgumentException("Votre  code a expiré");
        }
        UserDto userDto =  this.userRepository.findById(validationDto.getUserId())
                .map(userMapper::toUserDto)
                .orElseThrow(()-> new EntityNotFoundException("Utilisateur  introuvable"));
        userDto.setActived(true);
        this.userRepository.save(userMapper.toUserEntity(userDto));
    }
}
