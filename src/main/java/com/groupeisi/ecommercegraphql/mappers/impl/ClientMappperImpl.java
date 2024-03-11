package com.groupeisi.ecommercegraphql.mappers.impl;

import com.groupeisi.ecommercegraphql.dto.ClientRequestDto;
import com.groupeisi.ecommercegraphql.entities.Client;
import com.groupeisi.ecommercegraphql.mappers.ClientMappper;
import org.springframework.stereotype.Component;

@Component
public class ClientMappperImpl implements ClientMappper {
    @Override
    public Client toClientEntity(ClientRequestDto clientRequestDto) {
        Client client = new Client();
        client.setId(clientRequestDto.id());
        client.setNomComplet(clientRequestDto.nomComplet());
        client.setAdresse(clientRequestDto.adresse());
        client.setTelephone(clientRequestDto.telephone());
        return client;
    }

    @Override
    public ClientRequestDto toClientRequestDto(Client client) {
        return new ClientRequestDto(
                client.getId(),
                client.getNomComplet(),
                client.getAdresse(),
                client.getTelephone()
        );
    }
}
