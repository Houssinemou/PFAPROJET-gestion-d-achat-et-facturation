package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.dtos.VenteDto;
import com.emsi.gestion.de.vente.facturation.entities.Client;
import com.emsi.gestion.de.vente.facturation.entities.Produit;
import com.emsi.gestion.de.vente.facturation.entities.Vente;
import com.emsi.gestion.de.vente.facturation.exceptions.ResourceNotFoundException;
import com.emsi.gestion.de.vente.facturation.mappers.ProduitMapper;
import com.emsi.gestion.de.vente.facturation.mappers.VenteMapper;
import com.emsi.gestion.de.vente.facturation.repositories.ClientRepository;
import com.emsi.gestion.de.vente.facturation.repositories.ProduitRepository;
import com.emsi.gestion.de.vente.facturation.repositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenteServiceImpl implements VenteService{
    @Autowired
    private VenteRepository venteRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public VenteDto createVente(VenteDto venteDto) {
        Vente savedVente;
        if(venteDto.getClient_id()==null) {
            Vente vente = VenteMapper.mapToVente(venteDto);
            savedVente = venteRepository.save(vente);
        }else {
            Client client =clientRepository.findById(venteDto.getClient_id())
                    .orElseThrow(()-> new ResourceNotFoundException("Client does not exist with id: "+venteDto.getClient_id()));

            Vente vente =new Vente(
                    venteDto.getDateVente(),
                    venteDto.getStatut()
            );
            vente.setClient(null);
            vente.setClient(client);
            savedVente = venteRepository.save(vente);

        }


        return VenteMapper.mapToVenteDto(savedVente);
    }

    @Override
    public List<VenteDto> getAllventes() {
        List<Vente> ventes = venteRepository.findAll();
        return ventes.stream().map(VenteMapper::mapToVenteDto).collect(Collectors.toList());
    }

    @Override
    public VenteDto getVenteById(Long venteId) {
            Vente vente = venteRepository.findById(venteId)
                .orElseThrow(() -> new ResourceNotFoundException("Vente does not exist with id: " + venteId));
        return VenteMapper.mapToVenteDto(vente);
    }

    @Override
    public VenteDto updateVente(Long venteId, VenteDto venteDto) { Vente vente = venteRepository.findById(venteId)
            .orElseThrow(() -> new ResourceNotFoundException("vente Does not exist !"));
       vente.setDateVente(venteDto.getDateVente());
       vente.setStatut(venteDto.getStatut());

        Vente Updatedvente = venteRepository.save(vente);
        return VenteMapper.mapToVenteDto(Updatedvente);
    }

    @Override
    public void deleteVente(Long venteId) {
        Vente vente = venteRepository.findById(venteId)
                .orElseThrow(() -> new ResourceNotFoundException("vente Does not exist !"));
        venteRepository.deleteById(vente.getId());
    }
}
