package com.emsi.gestion.de.vente.facturation.services;

import com.emsi.gestion.de.vente.facturation.dtos.FactureDto;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfGenerationService {

    public byte[] generatePdf(FactureDto facture) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            Image logo = new Image(ImageDataFactory.create("src/main/resources/static/images/service.jpg"))
                    .setMaxWidth(100)
                    .setMaxHeight(100)
                    .setHorizontalAlignment(HorizontalAlignment.LEFT);

            Paragraph header = new Paragraph()
                    .add("Facture N°: " + facture.getId() + "\n")
                    .add("Date: " + facture.getDateFacturation() + "\n")
                    .add("Montant Total: " + facture.getMontantTotal() + "\n")
                    .add("Statut Paiement: " + facture.getStatutPaiement() + "\n")
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(12);

            Table headerTable = new Table(new float[]{1, 4});
            headerTable.setWidth(UnitValue.createPercentValue(100));
            headerTable.addCell(new Cell().add(logo).setBorder(Border.NO_BORDER));
            headerTable.addCell(new Cell().add(header).setBorder(Border.NO_BORDER));
            document.add(headerTable);

            LineSeparator line = new LineSeparator(new SolidLine());
            document.add(line);

            Table table = new Table(2);
            table.addCell("Client:");
            table.addCell("Telephone:");
            document.add(table);

            document.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
