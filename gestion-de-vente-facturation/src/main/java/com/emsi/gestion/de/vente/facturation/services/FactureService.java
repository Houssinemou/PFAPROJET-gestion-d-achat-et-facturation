package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.dtos.VenteDto;

import java.util.List;

public interface FactureService {
    FactureDto createFacture(FactureDto factureDto);
    List<FactureDto> getAllfacture();
    FactureDto getFactureById(Long factureId);
    FactureDto updateFacture(Long factureId, FactureDto factureDto);
    void deleteFacture(Long factureId);


}
