package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;

import java.util.List;

public interface ProduitService {
    ProduitDto createProduit(ProduitDto produitDtoDto);
    List<ProduitDto> getAllproduits();

    ProduitDto getProduitById(Long produitId);

    ProduitDto updateProduit(Long produitId, ProduitDto produitDto);

    void deleteProduit(Long produitId);
}
