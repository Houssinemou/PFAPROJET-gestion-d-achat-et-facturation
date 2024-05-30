package com.emsi.gestion.de.vente.facturation.dtos;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FactureDto {
    private Long Id;
    private Date DateFacturation;
    private Double MontantTotal;
    private String StatutPaiement;
    @Lob
    private byte[] PDF;

    private Long vente_id;
    public FactureDto(Long id, Date dateFacturation, Double montantTotal, String statutPaiement, byte[] pDF) {
        Id = id;
        DateFacturation = dateFacturation;
        MontantTotal = montantTotal;
        StatutPaiement = statutPaiement;
        PDF = pDF;
        vente_id=null;
    }
}
