package com.emsi.gestion.de.vente.facturation.services;


import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.emsi.gestion.de.vente.facturation.entities.Facture;
import com.emsi.gestion.de.vente.facturation.entities.Produit;
import com.emsi.gestion.de.vente.facturation.entities.Vente;
import com.emsi.gestion.de.vente.facturation.exceptions.ResourceNotFoundException;
import com.emsi.gestion.de.vente.facturation.mappers.FactureMapper;
import com.emsi.gestion.de.vente.facturation.mappers.ProduitMapper;
import com.emsi.gestion.de.vente.facturation.mappers.VenteMapper;
import com.emsi.gestion.de.vente.facturation.repositories.FactureRepository;
import com.emsi.gestion.de.vente.facturation.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureServiceImpl implements FactureService{
    @Autowired
    private FactureRepository factureRepository;
    @Override
    public FactureDto createFacture(FactureDto factureDto) {
        Facture facture = FactureMapper.mapToFacture(factureDto);
        Facture savedFacture=factureRepository.save(facture);


        return FactureMapper.mapToFactureDto(savedFacture);
    }

    @Override
    public List<FactureDto> getAllfacture() {
        List<Facture> factures = factureRepository.findAll();
        return factures.stream().map(FactureMapper::mapToFactureDto).collect(Collectors.toList());
    }

    @Override
    public FactureDto getFactureById(Long factureId) {
        Facture facture = factureRepository.findById(factureId)
                .orElseThrow(() -> new ResourceNotFoundException("facture does not exist with id: " + factureId));
        return FactureMapper.mapToFactureDto(facture);
    }

    @Override
    public FactureDto updateFacture(Long factureId, FactureDto factureDto) {
        Facture facture = factureRepository.findById(factureId)
                .orElseThrow(() -> new ResourceNotFoundException("facture does not exist with id: " + factureId));

        // Mettez à jour les champs de la facture avec les valeurs du DTO
        facture.setDateFacturation(factureDto.getDateFacturation());
        facture.setMontantTotal(factureDto.getMontantTotal());
        facture.setStatutPaiement(factureDto.getStatutPaiement());
        facture.setPDF(factureDto.getPDF());

        Facture updatedFacture = factureRepository.save(facture);
        return FactureMapper.mapToFactureDto(updatedFacture);
    }

    @Override
    public void deleteFacture(Long factureId) {
        Facture facture = factureRepository.findById(factureId)
                .orElseThrow(() -> new ResourceNotFoundException("facture Does not exist !"));
        factureRepository.deleteById(facture.getId());
    }


}
