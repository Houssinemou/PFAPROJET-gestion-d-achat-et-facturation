package com.emsi.gestion.de.vente.facturation.Configs;


import com.emsi.gestion.de.vente.facturation.entities.Role;
import com.emsi.gestion.de.vente.facturation.repositories.RoleRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class DataInitializer {

    @Bean
    public ApplicationRunner initializer(RoleRepository roleRepository) {
        return args -> {
            Optional<Role> userRole = roleRepository.findByName("USER");
            if (userRole.isEmpty()) {
                Role role = new Role();
                role.setName("USER");
                roleRepository.save(role);
            }

            Optional<Role> adminRole = roleRepository.findByName("ADMIN");
            if (adminRole.isEmpty()) {
                Role role = new Role();
                role.setName("ADMIN");
                roleRepository.save(role);
            }
        };
    }
}
