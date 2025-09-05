package com.app.pdf.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pdf.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadInvoice() {
        byte[] pdfBytes = invoiceService.generateInvoice(); // Get PDF as byte[]

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=invoice.pdf"); // Set filename
        headers.add("Content-Type", "application/pdf");
        headers.add("Content-Length", String.valueOf(pdfBytes.length));

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}
