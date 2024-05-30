package com.emsi.gestion.de.vente.facturation.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Date;
import java.util.Set;

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
    private Long Id;
    private Date dateVente;
    private String statut;


    @ManyToOne
    private Client client;

    @OneToOne
    @JoinColumn(name = "Facture_Id")
    private Facture facture;

    @OneToMany(mappedBy = "vente", cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<LignedeVente> ligneDeVente = new HashSet<>();

    public Vente(Date dateVente, String statut) {
        this.dateVente = dateVente;
        this.statut = statut;
    }
}
