package com.emsi.gestion.de.vente.facturation.mappers;

import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.emsi.gestion.de.vente.facturation.dtos.VenteDto;
import com.emsi.gestion.de.vente.facturation.entities.Facture;
import com.emsi.gestion.de.vente.facturation.entities.Vente;

public class VenteMapper {
    public static VenteDto mapToVenteDto(Vente vente){
        return new VenteDto(
                vente.getId(),
                vente.getDateVente(),
                vente.getStatut()


        );
    }
    public static Vente mapToVente(VenteDto venteDto) {
        return new Vente(
                venteDto.getId(),
                venteDto.getDateVente(),
                venteDto.getStatut()
        );
    }
}
