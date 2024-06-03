package com.emsi.gestion.de.vente.facturation.repositories;

import com.emsi.gestion.de.vente.facturation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
 Optional<Role> findByName(String name);
}
