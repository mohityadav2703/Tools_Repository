package com.app.pdf.service;

import org.springframework.stereotype.Service;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;


@Service
public class InvoiceService {
	
    public byte[] generateInvoice() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Title
            Paragraph title = new Paragraph("ORDER INVOICE")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(18);
            document.add(title);

            // Order Details
            document.add(new Paragraph("\nORDER #: 8535973"));
            document.add(new Paragraph("DATE: 11/03/2025, 10:54 AM"));

            // Seller Details
            document.add(new Paragraph("\nSELLER: Maxbhi.com")
                    .setBold());
            document.add(new Paragraph("318, 3rd Floor, Network Plaza, Saraswati Road, Karol Bagh, New Delhi"));
            document.add(new Paragraph("Phone: 9599197756"));

            // Buyer Details
            document.add(new Paragraph("\nBUYER: Mohit Kumar")
                    .setBold());
            document.add(new Paragraph("Flat no-507, Bhavya’s LIG, Kukatpally, Hyderabad"));
            document.add(new Paragraph("Phone: 9128441424"));

            // Table for Product Details
            Table table = new Table(new float[]{2, 5, 2, 2});
            table.setWidth(UnitValue.createPercentValue(100));
            table.addCell(new Cell().add(new Paragraph("Sr. No.").setBold()));
            table.addCell(new Cell().add(new Paragraph("Product").setBold()));
            table.addCell(new Cell().add(new Paragraph("Quantity").setBold()));
            table.addCell(new Cell().add(new Paragraph("Price").setBold()));

            table.addCell(new Cell().add(new Paragraph("1")));
            table.addCell(new Cell().add(new Paragraph("LCD with Touch Screen for Xiaomi Redmi 10 Prime - Black")));
            table.addCell(new Cell().add(new Paragraph("1")));
            table.addCell(new Cell().add(new Paragraph("949.00 Rs")));

            document.add(new Paragraph("\n"));
            document.add(table);

            // Amount & Declaration
            document.add(new Paragraph("\nAmount in Words: Nine Hundred and Thirty-Eight Rupees Only."));
            document.add(new Paragraph("\nDeclaration:\nWe declare that this invoice shows the actual price of the goods and is true and correct.")
                    .setItalic());

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }

}
