package com.emsi.gestion.de.vente.facturation.repositories;

import com.emsi.gestion.de.vente.facturation.entities.Client;
import com.emsi.gestion.de.vente.facturation.entities.LigneDeVenteKey;
import com.emsi.gestion.de.vente.facturation.entities.LignedeVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LignedeVenteRepository extends JpaRepository<LignedeVente, LigneDeVenteKey> {
}
