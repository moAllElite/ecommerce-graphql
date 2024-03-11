package com.groupeisi.ecommercegraphql.service.impl;

import com.groupeisi.ecommercegraphql.dto.CommandeRequestDto;
import com.groupeisi.ecommercegraphql.entities.Commande;
import com.groupeisi.ecommercegraphql.mappers.CommandeMapper;
import com.groupeisi.ecommercegraphql.repository.CommandeRepository;
import com.groupeisi.ecommercegraphql.service.ICommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements ICommandeService {
    private final CommandeRepository commandeRepository;
    private final CommandeMapper commandeMapper;
    private static final String ERRORMESSAGE="Commande %s not found";
    @Override
    public Commande createCommande(CommandeRequestDto commandeRequestDto) {
        return commandeRepository.save(
                commandeMapper.toCommandeEntity(commandeRequestDto)
        );
    }

    @Override
    public Commande findById(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException(String.format(ERRORMESSAGE, id)));
    }

    @Override
    public Commande updateCommande(Long id, CommandeRequestDto commandeRequestDto) {
        if(!commandeRepository.existsById(id)){
            throw new IllegalArgumentException(String.format(ERRORMESSAGE, id));
        }
        return commandeRepository.save(
                commandeMapper.toCommandeEntity(commandeRequestDto)
        );
    }

    @Override
    public void deleteCommande(Long id) {
        if(!commandeRepository.existsById(id)){
            throw new IllegalArgumentException(String.format(ERRORMESSAGE, id));
        }
        commandeRepository.deleteById(id);
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }
}
