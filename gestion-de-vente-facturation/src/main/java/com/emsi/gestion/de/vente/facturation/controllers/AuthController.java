package com.emsi.gestion.de.vente.facturation.controllers;

import com.emsi.gestion.de.vente.facturation.dtos.LoginDto;
import com.emsi.gestion.de.vente.facturation.dtos.RegisterDto;
import com.emsi.gestion.de.vente.facturation.entities.Role;
import com.emsi.gestion.de.vente.facturation.entities.Utilisateur;
import com.emsi.gestion.de.vente.facturation.repositories.RoleRepository;
import com.emsi.gestion.de.vente.facturation.repositories.UtilisateurRepository;
import com.emsi.gestion.de.vente.facturation.Security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManager authenticationManager;
    private final UtilisateurRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UtilisateurRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        logger.info("Register request received for username: {}", registerDto.getUsername());

        if (userRepository.existsByUsername(registerDto.getUsername())) {
            logger.warn("Username {} is already taken", registerDto.getUsername());
            return ResponseEntity.badRequest().body("Username is taken!");
        }

        Utilisateur user = new Utilisateur();
        user.setUsername(registerDto.getUsername());
        user.setMotDePasse(passwordEncoder.encode(registerDto.getPassword()));

        Role role = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoles(Collections.singletonList(role));

        userRepository.save(user);
        logger.info("User {} registered successfully", registerDto.getUsername());
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/register-admin")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterDto registerDto) {
        logger.info("Register request received for admin username: {}", registerDto.getUsername());

        if (userRepository.existsByUsername(registerDto.getUsername())) {
            logger.warn("Admin username {} is already taken", registerDto.getUsername());
            return ResponseEntity.badRequest().body("Username is taken!");
        }

        Utilisateur user = new Utilisateur();
        user.setUsername(registerDto.getUsername());
        user.setMotDePasse(passwordEncoder.encode(registerDto.getPassword()));

        Role role = roleRepository.findByName("ADMIN").orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoles(Collections.singletonList(role));

        userRepository.save(user);
        logger.info("Admin user {} registered successfully", registerDto.getUsername());
        return ResponseEntity.ok("Admin user registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        logger.info("Login request received for username: {}", loginDto.getUsername());
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);
            logger.info("Login successful for username: {}", loginDto.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Login failed for username: {}", loginDto.getUsername(), e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<Utilisateur>> getAllUsers() {
        List<Utilisateur> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return ResponseEntity.ok(roles);
    }
}
