package com.emsi.gestion.de.vente.facturation.mappers;

import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.entities.Facture;
import com.emsi.gestion.de.vente.facturation.entities.Produit;

public class FactureMapper {
    public static FactureDto mapToFactureDto(Facture facture){
        return new FactureDto(
                facture.getId(),
                facture.getDateFacturation(),
                facture.getMontantTotal(),
                facture.getStatutPaiement(),
                facture.getPDF(),
                facture.getVente().getId()


        );
    }
    public static Facture mapToFacture(FactureDto factureDto) {
        return new Facture(
                factureDto.getId(),
                factureDto.getDateFacturation(),
                factureDto.getMontantTotal(),
                factureDto.getStatutPaiement(),
                factureDto.getPDF()
        );
    }
}
