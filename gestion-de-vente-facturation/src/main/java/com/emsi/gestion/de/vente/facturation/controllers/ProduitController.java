package com.emsi.gestion.de.vente.facturation.controllers;

import com.emsi.gestion.de.vente.facturation.dtos.ClientDto;
import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.entities.Produit;
import com.emsi.gestion.de.vente.facturation.services.ClientService;
import com.emsi.gestion.de.vente.facturation.services.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @PostMapping
    public ResponseEntity<ProduitDto> createProduit(@RequestBody ProduitDto produitDto){
        ProduitDto savedProduit=produitService.createProduit(produitDto);
        return new ResponseEntity<>(savedProduit, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ProduitDto>> getAllProduits()
    {
        return ResponseEntity.ok(produitService.getAllproduits());
    }
}
