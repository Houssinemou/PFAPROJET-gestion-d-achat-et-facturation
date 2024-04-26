package com.emsi.gestion.de.vente.facturation.dtos;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDto {
    private Long Id;
    private String Nom;
    private String Description;
    private Double Prix;
    private int QuantitéEnStock;
    @Lob
    private byte[] image;
}
