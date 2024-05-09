package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.ClientDto;
import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.dtos.VenteDto;

import java.util.List;

public interface VenteService {
    VenteDto createVente(VenteDto venteDto);
    List<VenteDto> getAllventes();
    VenteDto getVenteById(Long venteId);
    VenteDto updateVente(Long venteId, VenteDto updatedVenteDto);
    void deleteVente(Long venteId);
}
