package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.emsi.gestion.de.vente.facturation.dtos.LignedeVenteDto;
import com.emsi.gestion.de.vente.facturation.entities.LigneDeVenteKey;

import java.util.List;

public interface LignedeVenteService {
    LignedeVenteDto createLignedeVente(LignedeVenteDto lignedeVenteDto);
    List<LignedeVenteDto> getAllLignedeVente();
    LignedeVenteDto getLignedeVenteById(LigneDeVenteKey lignedeVenteId);
    LignedeVenteDto updateLignedeVente(LigneDeVenteKey lignedeVenteId, LignedeVenteDto lignedeVenteDto);
    void deleteLigneDeVente(LigneDeVenteKey lignedeVenteId);
}
