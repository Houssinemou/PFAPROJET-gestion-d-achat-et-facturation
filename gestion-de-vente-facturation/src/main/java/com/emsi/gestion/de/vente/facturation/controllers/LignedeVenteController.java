package com.emsi.gestion.de.vente.facturation.controllers;

import com.emsi.gestion.de.vente.facturation.dtos.LignedeVenteDto;
import com.emsi.gestion.de.vente.facturation.entities.LigneDeVenteKey;
import com.emsi.gestion.de.vente.facturation.services.LignedeVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lignedevente")
public class LignedeVenteController {

    @Autowired
    private LignedeVenteService lignedeVenteService;

    @PostMapping
    public ResponseEntity<LignedeVenteDto> createLignedeVente(@RequestBody LignedeVenteDto lignedeVenteDto) {
        System.out.println("Id of vente&produit : " + lignedeVenteDto.getId().getVenteId()+" "+lignedeVenteDto.getId().getProduitId() + "quantity : " + lignedeVenteDto.getQuantite() + "Prix Unitaire : " + lignedeVenteDto.getPrixUnitaire());
        LignedeVenteDto createdLignedeVente = lignedeVenteService.createLignedeVente(lignedeVenteDto);
        return new ResponseEntity<>(createdLignedeVente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LignedeVenteDto>> getAllLignedeVente() {
        List<LignedeVenteDto> allLignedeVente = lignedeVenteService.getAllLignedeVente();
        return new ResponseEntity<>(allLignedeVente, HttpStatus.OK);
    }

    @GetMapping("/{venteId}/{produitId}")
    public ResponseEntity<LignedeVenteDto> getLignedeVenteById(@PathVariable Long venteId, @PathVariable Long produitId) {
        LigneDeVenteKey lignedeVenteId = new LigneDeVenteKey(venteId, produitId);
        LignedeVenteDto lignedeVente = lignedeVenteService.getLignedeVenteById(lignedeVenteId);
        return new ResponseEntity<>(lignedeVente, HttpStatus.OK);
    }

    @PutMapping("/{venteId}/{produitId}")
    public ResponseEntity<LignedeVenteDto> updateLignedeVente(@PathVariable Long venteId, @PathVariable Long produitId, @RequestBody LignedeVenteDto lignedeVenteDto) {
        LigneDeVenteKey lignedeVenteId = new LigneDeVenteKey(venteId, produitId);
        LignedeVenteDto updatedLignedeVente = lignedeVenteService.updateLignedeVente(lignedeVenteId, lignedeVenteDto);
        return new ResponseEntity<>(updatedLignedeVente, HttpStatus.OK);
    }

    @DeleteMapping("/{venteId}/{produitId}")
    public ResponseEntity<Void> deleteLignedeVente(@PathVariable Long venteId, @PathVariable Long produitId) {
        LigneDeVenteKey lignedeVenteId = new LigneDeVenteKey(venteId, produitId);
        lignedeVenteService.deleteLigneDeVente(lignedeVenteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
