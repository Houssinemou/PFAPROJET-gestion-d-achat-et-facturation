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
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nom;
    private String email;
    private String motDePasse;
    private String role;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY)
    private List<Client> clients=new ArrayList<>();




}
