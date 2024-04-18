package com.emsi.gestion.de.vente.facturation.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;
    private String nom;
    private String adresse;
    private String email;
    private int telephone;
    private String historiqueAchats;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Vente>ventes=new ArrayList<>();




}
