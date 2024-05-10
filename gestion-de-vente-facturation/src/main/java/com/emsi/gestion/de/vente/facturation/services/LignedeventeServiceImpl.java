package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.LignedeVenteDto;
import com.emsi.gestion.de.vente.facturation.entities.Facture;
import com.emsi.gestion.de.vente.facturation.entities.LigneDeVenteKey;
import com.emsi.gestion.de.vente.facturation.entities.LignedeVente;
import com.emsi.gestion.de.vente.facturation.exceptions.ResourceNotFoundException;
import com.emsi.gestion.de.vente.facturation.mappers.FactureMapper;
import com.emsi.gestion.de.vente.facturation.mappers.LignedeVenteMapper;
import com.emsi.gestion.de.vente.facturation.repositories.FactureRepository;
import com.emsi.gestion.de.vente.facturation.repositories.LignedeVenteRepository;
import com.emsi.gestion.de.vente.facturation.repositories.ProduitRepository;
import com.emsi.gestion.de.vente.facturation.repositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LignedeventeServiceImpl implements LignedeVenteService{
    @Autowired
    private LignedeVenteRepository lignedeVenteRepository;

    @Autowired
    private VenteRepository venteRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public LignedeVenteDto createLignedeVente(LignedeVenteDto lignedeVenteDto) {
        //LignedeVente lignedeVente = LignedeVenteMapper.mapToLignedeVente(lignedeVenteDto);
        //LignedeVente savedLignedeVente=lignedeVenteRepository.save(lignedeVente);
        LignedeVente lignedeVente = new LignedeVente(
                new LigneDeVenteKey(lignedeVenteDto.getId().getVenteId(), lignedeVenteDto.getId().getProduitId()),
                lignedeVenteDto.getQuantite(),
                lignedeVenteDto.getPrixUnitaire()
        );
        lignedeVente.setVente(venteRepository.findById(lignedeVenteDto.getId().getVenteId()).orElseThrow(()-> new ResourceNotFoundException("vente Does not exist !") ));
        lignedeVente.setProduit(produitRepository.findById(lignedeVenteDto.getId().getProduitId()).orElseThrow(()-> new ResourceNotFoundException("produit Does not exist !") ));
        return LignedeVenteMapper.mapToLignedeVenteDto(lignedeVenteRepository.save(lignedeVente));
        //return LignedeVenteMapper.mapToLignedeVenteDto(savedLignedeVente);
    }

    @Override
    public List<LignedeVenteDto> getAllLignedeVente() {
        List<LignedeVente> lignedeVentes = lignedeVenteRepository.findAll();
        return lignedeVentes.stream().map(LignedeVenteMapper::mapToLignedeVenteDto).collect(Collectors.toList());
    }

    @Override
    public LignedeVenteDto getLignedeVenteById(LigneDeVenteKey lignedeVenteId) {

        LignedeVente lignedeVente = lignedeVenteRepository.findById(lignedeVenteId)
                .orElseThrow(() -> new ResourceNotFoundException("lignedevente does not exist with id: " + lignedeVenteId));
        return LignedeVenteMapper.mapToLignedeVenteDto(lignedeVente);
    }

    @Override
    public LignedeVenteDto updateLignedeVente(LigneDeVenteKey lignedeVenteId, LignedeVenteDto lignedeVenteDto) {
        LignedeVente lignedeVente = lignedeVenteRepository.findById(lignedeVenteId)
                .orElseThrow(() -> new ResourceNotFoundException("lignedevente Does not exist !"));
        lignedeVente.setId(lignedeVenteDto.getId());
        lignedeVente.setQuantite(lignedeVenteDto.getQuantite());
        lignedeVente.setPrixUnitaire(lignedeVenteDto.getPrixUnitaire());


        LignedeVente UpdatedLignedeVente = lignedeVenteRepository.save(lignedeVente);
        return LignedeVenteMapper.mapToLignedeVenteDto(UpdatedLignedeVente);
    }

    @Override
    public void deleteLigneDeVente(LigneDeVenteKey lignedeVenteId) {
        LignedeVente lignedeVente = lignedeVenteRepository.findById(lignedeVenteId)
                .orElseThrow(() -> new ResourceNotFoundException("lignedeVente Does not exist !"));
        lignedeVenteRepository.deleteById(lignedeVente.getId());
    }


}
