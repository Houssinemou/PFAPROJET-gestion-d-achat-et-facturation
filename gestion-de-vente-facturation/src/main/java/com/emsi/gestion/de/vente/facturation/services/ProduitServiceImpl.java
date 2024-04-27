package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.entities.Client;
import com.emsi.gestion.de.vente.facturation.entities.Produit;
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
}
