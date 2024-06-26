package com.emsi.gestion.de.vente.facturation.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private Date DateFacturation;
    private Double MontantTotal;
    private String StatutPaiement;
    @Lob
    private byte[] PDF;

    @OneToOne
    @JoinColumn(name = "Vente_Id")
    private Vente vente;


    public Facture(Long id, Date dateFacturation, Double montantTotal, String statutPaiement, byte[] PDF) {
        Id = id;
        DateFacturation = dateFacturation;
        MontantTotal = montantTotal;
        StatutPaiement = statutPaiement;
        this.PDF = PDF;
    }

    public Facture(Date dateFacturation, Double montantTotal, String statutPaiement, byte[] pdf) {
        DateFacturation = dateFacturation;
        MontantTotal = montantTotal;
        StatutPaiement = statutPaiement;
        this.PDF = PDF;
    }
}
