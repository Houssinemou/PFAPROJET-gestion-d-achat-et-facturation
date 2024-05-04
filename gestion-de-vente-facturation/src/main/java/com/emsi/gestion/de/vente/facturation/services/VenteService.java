package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.dtos.VenteDto;

import java.util.List;

public interface VenteService {
    VenteDto createVente(VenteDto venteDto);
    List<VenteDto> getAllventes();
}
