package com.emsi.gestion.de.vente.facturation.repositories;

import com.emsi.gestion.de.vente.facturation.entities.Client;
import com.emsi.gestion.de.vente.facturation.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    Optional<Utilisateur> findByUsername(String username);
    Boolean existsByUsername(String username);
}
