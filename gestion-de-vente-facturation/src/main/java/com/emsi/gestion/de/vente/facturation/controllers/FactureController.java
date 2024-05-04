package com.emsi.gestion.de.vente.facturation.controllers;

import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.services.FactureService;
import com.emsi.gestion.de.vente.facturation.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facture")
public class FactureController {
    @Autowired
    private FactureService factureService;

    @PostMapping
    public ResponseEntity<FactureDto> createFacture(@RequestBody FactureDto factureDto){
        FactureDto savedFacture=factureService.createFacture(factureDto);
        return new ResponseEntity<>(savedFacture, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<FactureDto>> getAllfactures()
    {
        return ResponseEntity.ok(factureService.getAllfacture());
    }
}
