package com.emsi.gestion.de.vente.facturation.dtos;

import com.emsi.gestion.de.vente.facturation.entities.Vente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private Long Id;
    private String nom;
    private String adresse;
    private String email;
    private String telephone;
    private String historiqueAchats;
    private String HiVentes;

}
