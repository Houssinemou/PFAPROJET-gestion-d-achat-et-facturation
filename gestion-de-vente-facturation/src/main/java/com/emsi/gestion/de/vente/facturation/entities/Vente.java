package com.emsi.gestion.de.vente.facturation.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private Date dateVente;
    private String statut;


    @ManyToOne
    private Client client;
    @ManyToMany
    @JoinTable(name = "Lignedevente")
    private List<LignedeVente>Lignedevente=new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "Facture_Id")
    private Facture facture;

}
