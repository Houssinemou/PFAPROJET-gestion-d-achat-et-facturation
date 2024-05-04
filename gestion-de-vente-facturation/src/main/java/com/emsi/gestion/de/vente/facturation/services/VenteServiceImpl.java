package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.ProduitDto;
import com.emsi.gestion.de.vente.facturation.dtos.VenteDto;
import com.emsi.gestion.de.vente.facturation.entities.Produit;
import com.emsi.gestion.de.vente.facturation.entities.Vente;
import com.emsi.gestion.de.vente.facturation.mappers.ProduitMapper;
import com.emsi.gestion.de.vente.facturation.mappers.VenteMapper;
import com.emsi.gestion.de.vente.facturation.repositories.ProduitRepository;
import com.emsi.gestion.de.vente.facturation.repositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenteServiceImpl implements VenteService{
    @Autowired
    private VenteRepository venteRepository;
    @Override
    public VenteDto createVente(VenteDto venteDto) {
        Vente vente = VenteMapper.mapToVente(venteDto);
        Vente savedVente=venteRepository.save(vente);


        return VenteMapper.mapToVenteDto(savedVente);
    }

    @Override
    public List<VenteDto> getAllventes() {
        List<Vente> ventes = venteRepository.findAll();
        return ventes.stream().map(VenteMapper::mapToVenteDto).collect(Collectors.toList());
    }
}
