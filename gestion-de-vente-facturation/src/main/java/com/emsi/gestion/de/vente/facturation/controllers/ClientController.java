package com.emsi.gestion.de.vente.facturation.controllers;

import com.emsi.gestion.de.vente.facturation.dtos.ClientDto;
import com.emsi.gestion.de.vente.facturation.entities.Client;
import com.emsi.gestion.de.vente.facturation.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto){
        ClientDto savedClient=clientService.createClient(clientDto);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients()
    {
        return ResponseEntity.ok(clientService.getAllclients());
    }
    @GetMapping("{Id}")
    public ResponseEntity<ClientDto> getclientById(@PathVariable("Id") Long ClientId)
    {
        ClientDto clientDto = clientService.getclientById(ClientId);
        return ResponseEntity.ok(clientDto);
    }
    @PutMapping("{Id}")
    public ResponseEntity<ClientDto> updatecontact(@PathVariable("Id") Long ClientId, @RequestBody ClientDto clientDto)
    {
         ClientDto client = clientService.updatecontact(ClientId,clientDto);
        return ResponseEntity.ok(clientDto);
    }
    @DeleteMapping("{Id}")
    public ResponseEntity<String> deleteclient(@PathVariable("Id") Long ClientId)
    {
        clientService.deleteclient(ClientId);
        return ResponseEntity.ok("client Deleted Successfully !.");
    }




}
