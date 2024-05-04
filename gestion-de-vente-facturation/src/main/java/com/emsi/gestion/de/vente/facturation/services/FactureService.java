package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;

import java.util.List;

public interface FactureService {
    FactureDto createFacture(FactureDto factureDto);
    List<FactureDto> getAllfacture();


}
