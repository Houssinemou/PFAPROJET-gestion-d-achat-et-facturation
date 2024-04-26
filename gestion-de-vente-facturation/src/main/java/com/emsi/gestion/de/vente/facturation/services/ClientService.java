package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);
    ClientDto getclientById(Long clientId);

    List<ClientDto> getAllclients();

    ClientDto updatecontact(Long clientId,ClientDto updatedclientDto);

    void deleteclient(Long clientId);

}
