package com.groupeisi.ecommercegraphql.service.impl;

import com.groupeisi.ecommercegraphql.dto.ClientRequestDto;
import com.groupeisi.ecommercegraphql.entities.Client;
import com.groupeisi.ecommercegraphql.repository.ClientRepository;
import com.groupeisi.ecommercegraphql.service.IClientService;
import com.groupeisi.ecommercegraphql.mappers.ClientMappper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class ClientServiceImpl implements IClientService {
    private final ClientRepository clientRepository;
    private  final ClientMappper clientMapper;
    private static final String ERRORMESSAGE= "Client with %s was not found  ";
    @Override
    public Client save(ClientRequestDto clientRequestDto) {
        return clientRepository.save(clientMapper.toClientEntity(clientRequestDto));
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException(
                            String.format(ERRORMESSAGE, id)
                        )
                );
    }

    @Override
    public Client update(Long id, ClientRequestDto clientRequestDto) {
        if (!clientRepository.existsById(id)) {
            throw new IllegalArgumentException(
                    String.format(ERRORMESSAGE, id)
            );
        }
        return clientRepository.save(clientMapper.toClientEntity(clientRequestDto));
    }

    @Override
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new IllegalArgumentException(
                    String.format(ERRORMESSAGE, id)
            );
        }
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
