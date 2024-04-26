package com.emsi.gestion.de.vente.facturation.mappers;

import com.emsi.gestion.de.vente.facturation.dtos.ClientDto;
import com.emsi.gestion.de.vente.facturation.entities.Client;

public class ClientMapper {
    public static ClientDto mapToClientDto(Client client){
        return new ClientDto(
                client.getId(),
                client.getNom(),
                client.getEmail(),
                client.getAdresse(),
                client.getTelephone(),
                client.getHistoriqueAchats(),
                client.getHiVentes()
        );
    }
    public static Client mapToClient(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getNom(),
                clientDto.getEmail(),
                clientDto.getAdresse(),
                clientDto.getTelephone(),
                clientDto.getHistoriqueAchats(),
                clientDto.getHiVentes()
        );
    }
}
