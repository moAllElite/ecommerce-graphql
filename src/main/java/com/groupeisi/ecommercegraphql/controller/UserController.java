package com.groupeisi.ecommercegraphql.controller;


import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UserController {

    private final IUserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    public void register(@Valid @RequestBody UserDto userDto) {
        userService.save(userDto);
        log.info("register succesfull");
    }
}
