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


}
