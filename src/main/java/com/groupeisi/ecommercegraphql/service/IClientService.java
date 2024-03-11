package com.groupeisi.ecommercegraphql.service;

import com.groupeisi.ecommercegraphql.dto.ClientRequestDto;
import com.groupeisi.ecommercegraphql.entities.Client;

import java.util.List;

public interface IClientService {

    Client save(ClientRequestDto clientRequestDto);
    Client findById(Long id);
    Client update(Long id,ClientRequestDto clientRequestDto);

    void delete(Long id);
    List<Client> findAll();
}
