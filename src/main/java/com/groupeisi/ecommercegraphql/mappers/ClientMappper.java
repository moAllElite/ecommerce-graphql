package com.groupeisi.ecommercegraphql.mappers;

import com.groupeisi.ecommercegraphql.dto.ClientRequestDto;
import com.groupeisi.ecommercegraphql.entities.Client;

public interface ClientMappper {
    Client toClientEntity(ClientRequestDto clientRequestDto);
    ClientRequestDto toClientRequestDto(Client client);
}
