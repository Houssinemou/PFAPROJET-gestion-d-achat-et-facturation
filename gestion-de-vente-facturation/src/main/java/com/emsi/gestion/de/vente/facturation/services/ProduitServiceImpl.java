package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.entities.Client;
import com.emsi.gestion.de.vente.facturation.entities.Produit;
import com.emsi.gestion.de.vente.facturation.exceptions.ResourceNotFoundException;
import com.emsi.gestion.de.vente.facturation.mappers.ClientMapper;
import com.emsi.gestion.de.vente.facturation.mappers.ProduitMapper;
import com.emsi.gestion.de.vente.facturation.repositories.ClientRepository;
import com.emsi.gestion.de.vente.facturation.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public ProduitDto createProduit(ProduitDto produitDto) {
        Produit produit = ProduitMapper.mapToProduit(produitDto);
        Produit savedProduit=produitRepository.save(produit);


        return ProduitMapper.mapToProduitDto(savedProduit);
    }

    @Override
    public List<ProduitDto> getAllproduits() {
        List<Produit> produits = produitRepository.findAll();
        return produits.stream().map(ProduitMapper::mapToProduitDto).collect(Collectors.toList());
    }

    @Override
    public ProduitDto getProduitById(Long produitId) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("Produit does not exist with id: " + produitId));
        return ProduitMapper.mapToProduitDto(produit);
    }

    @Override
    public ProduitDto updateProduit(Long produitId, ProduitDto produitDto) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("produit Does not exist !"));
        produit.setNom(produitDto.getNom());
        produit.setDescription(produitDto.getDescription());
        produit.setPrix(produitDto.getPrix());
        produit.setQuantitéEnStock(produitDto.getQuantitéEnStock());
        produit.setImage(produitDto.getImage());

        Produit Updatedproduit = produitRepository.save(produit);
        return ProduitMapper.mapToProduitDto(Updatedproduit);
    }

    @Override
    public void deleteProduit(Long produitId) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("produit Does not exist !"));
        produitRepository.deleteById(produit.getId());
    }
}
