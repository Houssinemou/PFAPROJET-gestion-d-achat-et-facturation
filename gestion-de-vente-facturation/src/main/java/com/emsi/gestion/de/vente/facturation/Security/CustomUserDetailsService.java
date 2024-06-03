package com.emsi.gestion.de.vente.facturation.Security;

import com.emsi.gestion.de.vente.facturation.entities.Role;
import com.emsi.gestion.de.vente.facturation.entities.Utilisateur;
import com.emsi.gestion.de.vente.facturation.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UtilisateurRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user=userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new User(user.getUsername(),user.getMotDePasse(),mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}