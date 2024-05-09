package com.emsi.gestion.de.vente.facturation.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String nom;
    private String adresse;
    private String email;
    private String telephone;
    private String historiqueAchats;
    private String HiVentes;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Vente>ventes=new ArrayList<>();

    public Client(Long id, String nom, String adresse, String email, String telephone, String historiqueAchats, String hiVentes, Utilisateur utilisateur, List<Vente> ventes) {
        Id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.historiqueAchats = historiqueAchats;
        HiVentes = hiVentes;
        this.utilisateur = utilisateur;
        this.ventes = ventes;
    }


    public Client(Long id, String nom, String email, String adresse, String telephone, String historiqueAchats, String hiVentes) {
        Id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.historiqueAchats = historiqueAchats;
        HiVentes = hiVentes;
    }
}
