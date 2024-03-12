package com.groupeisi.ecommercegraphql.controller;


import com.groupeisi.ecommercegraphql.dto.RoleDto;
import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.TypeDeRole;
import com.groupeisi.ecommercegraphql.service.IUserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UserController {
    private static final String EMAILREGEX= "^(.+)@(.+)$";
    private final IUserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    public void register(@RequestBody UserDto userDto)  {
        // vérifie si le mail est valide
        if(!userDto.getEmail().matches(EMAILREGEX)){
            throw new EntityNotFoundException(
                    String.format("Email %s pourvue est invalide",userDto.getEmail()));
        }
        // vérifie si l'email existe
       Optional  <UserDto> userExist = userService.findByEmail(userDto.getEmail());
        if(userExist.isPresent()){
         throw new EntityExistsException(
                 String.format("Email %s est déjà pourvu ",userDto.getEmail())
         );
        }
        // crypter le mot de passe
        String pwdBcrypt = this.passwordEncoder.encode(userDto.getPassword());

        //new role
        RoleDto savedRole = new RoleDto();
        savedRole.setLibelle(TypeDeRole.USER);

        userDto.setPassword(pwdBcrypt);
        userDto.setRoleDto(savedRole);
        userService.save(userDto);
        log.info("register succesfull");

    }
}
