package com.groupeisi.ecommercegraphql.controller;
import com.groupeisi.ecommercegraphql.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ClientGraphQLController {
    private  final IClientService clientService;


}
