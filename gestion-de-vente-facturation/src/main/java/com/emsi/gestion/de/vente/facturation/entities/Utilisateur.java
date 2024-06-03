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
    private Long Id;
    private String username;
    private String motDePasse;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY)
    private List<Client> clients=new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
       inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roles=new ArrayList<>();


}
