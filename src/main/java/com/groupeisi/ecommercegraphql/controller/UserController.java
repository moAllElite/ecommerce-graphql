package com.groupeisi.ecommercegraphql.controller;


import com.groupeisi.ecommercegraphql.dto.AuthentificationDto;
import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.TypeDeRole;

import com.groupeisi.ecommercegraphql.service.IUserService;
import com.groupeisi.ecommercegraphql.service.JwtService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@AllArgsConstructor
@Slf4j
@RequestMapping
@RestController
public class UserController {

    private final IUserService userService;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "register")
    public void register(
            @RequestParam(defaultValue ="USER") TypeDeRole roleName,
            @Valid @RequestBody UserDto userDto
    ) throws MessagingException {
         userService.save(roleName,userDto);

        log.info("register succesfull");
    }
    @PostMapping(path = "activation")
    public void active(@RequestBody Map<String,String> activation) {
        this.userService.activation(activation);
    }

    @PostMapping(path = "signin")
    public Map<String, String> login(@RequestBody AuthentificationDto authentificationDto) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDto.username(), authentificationDto.password())
        );
        if (authenticate.isAuthenticated()) {
          return    this.jwtService.generate(authentificationDto.username());
        }
        return Collections.emptyMap();
    }
}
