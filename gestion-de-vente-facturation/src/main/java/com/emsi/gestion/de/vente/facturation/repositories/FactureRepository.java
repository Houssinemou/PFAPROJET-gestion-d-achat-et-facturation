package com.emsi.gestion.de.vente.facturation.repositories;

import com.emsi.gestion.de.vente.facturation.entities.Client;
import com.emsi.gestion.de.vente.facturation.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
}
