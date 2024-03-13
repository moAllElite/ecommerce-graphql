package com.groupeisi.ecommercegraphql.controller;


import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UserController {

    private final IUserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/register")
    public void register(@Valid @RequestBody UserDto userDto) {
        userService.save(userDto);
        log.info("register succesfull");
    }
    @PostMapping(path = "/activation")
    public void active(@RequestBody Map<String,String> activation) {
        this.userService.activation(activation);
    }
    @GetMapping( path="/home")
    public String home(){
        return "home_mailing";
    }
}
