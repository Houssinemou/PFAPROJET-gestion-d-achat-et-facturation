package com.emsi.gestion.de.vente.facturation.controllers;

import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.emsi.gestion.de.vente.facturation.dtos.VenteDto;
import com.emsi.gestion.de.vente.facturation.services.FactureService;
import com.emsi.gestion.de.vente.facturation.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vente")
public class VenteController {
    @Autowired
    private VenteService venteService;
    @PostMapping
    public ResponseEntity<VenteDto> createVente(@RequestBody VenteDto venteDto){
        VenteDto savedVente=venteService.createVente(venteDto);
        return new ResponseEntity<>(savedVente, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<VenteDto>> getAllventes()
    {
        return ResponseEntity.ok(venteService.getAllventes());
    }
}
