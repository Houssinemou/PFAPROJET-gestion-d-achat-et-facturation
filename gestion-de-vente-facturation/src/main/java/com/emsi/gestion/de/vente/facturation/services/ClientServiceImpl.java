package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.ClientDto;
import com.emsi.gestion.de.vente.facturation.entities.Client;
import com.emsi.gestion.de.vente.facturation.exceptions.ResourceNotFoundException;
import com.emsi.gestion.de.vente.facturation.mappers.ClientMapper;
import com.emsi.gestion.de.vente.facturation.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    @Autowired
   private ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = ClientMapper.mapToClient(clientDto);
        Client savedClient=clientRepository.save(client);


        return ClientMapper.mapToClientDto(savedClient);
    }

    @Override
    public ClientDto getclientById(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("client Does not exist !");
                });
        return ClientMapper.mapToClientDto(client);
    }

    @Override
    public List<ClientDto> getAllclients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map((client) -> ClientMapper.mapToClientDto(client)).collect(Collectors.toList());
    }

    @Override
    public ClientDto updatecontact(Long clientId, ClientDto updatedclientDto) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("client Does not exist !"));

        client.setNom(updatedclientDto.getNom());        client.setEmail(updatedclientDto.getEmail()); client.setAdresse(updatedclientDto.getAdresse());
        client.setTelephone(updatedclientDto.getTelephone());client.setHistoriqueAchats(updatedclientDto.getHistoriqueAchats());
        client.setHiVentes(updatedclientDto.getHiVentes());
        Client Updatedclient = clientRepository.save(client);
        return ClientMapper.mapToClientDto(Updatedclient);
    }

    @Override
    public void deleteclient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("client Does not exist !"));
        clientRepository.deleteById(client.getId());
    }
}
