package com.emsi.gestion.de.vente.facturation.mappers;

import com.emsi.gestion.de.vente.facturation.dtos.ClientDto;
import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.entities.Client;
import com.emsi.gestion.de.vente.facturation.entities.Produit;

public class ProduitMapper {
    public static ProduitDto mapToProduitDto(Produit produit){
        return new ProduitDto(
                produit.getId(),
                produit.getNom(),
                produit.getDescription(),
                produit.getPrix(),
                produit.getQuantitéEnStock(),
                produit.getImage()
        );
    }
    public static Produit mapToProduit(ProduitDto produitDto) {
        return new Produit(
                produitDto.getId(),
                produitDto.getNom(),
                produitDto.getDescription(),
                produitDto.getPrix(),
                produitDto.getQuantitéEnStock(),
                produitDto.getImage()
        );
    }
}
