package com.emsi.gestion.de.vente.facturation.controllers;

import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.emsi.gestion.de.vente.facturation.entities.Facture;
import com.emsi.gestion.de.vente.facturation.services.FactureService;
import com.emsi.gestion.de.vente.facturation.services.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facture")
public class FactureController {
    @Autowired
    private FactureService factureService;
    @Autowired
    private PdfGenerationService pdfGenerationService;

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
    @GetMapping("/{id}")
    public ResponseEntity<FactureDto> getFactureById(@PathVariable("id") Long factureId) {
        FactureDto factureDto = factureService.getFactureById(factureId);
        return ResponseEntity.ok(factureDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FactureDto> updateFacture(@PathVariable("id") Long factureId, @RequestBody FactureDto factureDto) {
        FactureDto updatedFacture = factureService.updateFacture(factureId, factureDto);
        return ResponseEntity.ok(updatedFacture);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacture(@PathVariable("id") Long factureId) {
        factureService.deleteFacture(factureId);
        return ResponseEntity.ok("facture deleted successfully.");
    }
    @GetMapping({"/{id}/pdf"})
    public ResponseEntity<byte[]> generatePdfForFacture(@PathVariable Long factureId) {
        FactureDto facture = this.factureService.getFactureById(factureId);
        byte[] pdfBytes = this.pdfGenerationService.generatePdf(facture);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(pdfBytes);
    }
}
