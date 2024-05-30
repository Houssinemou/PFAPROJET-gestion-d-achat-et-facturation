package com.emsi.gestion.de.vente.facturation.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VenteDto {
    private Long Id;
    private Date dateVente;
    private String statut;
    private Long client_id;


}
