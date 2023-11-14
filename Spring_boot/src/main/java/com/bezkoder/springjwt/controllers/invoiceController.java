package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.invoice;
import com.bezkoder.springjwt.service.invoiceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Document;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class invoiceController {

    @Autowired
    private invoiceService invoiceService;
    @GetMapping("/invoice")
    public List<invoice> getfacture(){
        return invoiceService.getfacture();}

    @GetMapping("/Sumtotal")
    public List<Object[]> getSumTotalTtc(){
        return invoiceService.getSumTotalTtc();}


    @GetMapping("/invoice/{id}")
    public ResponseEntity<?> getfacture(@PathVariable Long id) {
        if (invoiceService.existsById(id)) {
            invoice requestedFacture = invoiceService.getfactureById(id).orElseThrow(() -> new EntityNotFoundException("Requested facture not found"));;
            return ResponseEntity.ok(requestedFacture);
        } else {
            String errorMessage = "Requested facture with id: " + id + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }


    @PostMapping("/invoice")
    public invoice addfacture (@RequestBody invoice facture ){
        return invoiceService.save(facture);}


    @PutMapping("invoice/{id}")
    public ResponseEntity<?> putfacture(@RequestBody invoice facture,@PathVariable long id) {
        if (invoiceService.existsById(id))
        {
            invoice facture1 = invoiceService.getfactureById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Requested facture not found"));


            facture1.setClient(facture.getClient());
            facture1.setTotalTTC(facture.getTotalTTC());
            facture1.setTelFournisseur(facture.getTelFournisseur());
            facture1.setFournisseur(facture.getFournisseur());
            facture1.setTelClient(facture.getTelClient());
            facture1.setDate(facture.getDate());
            facture1.setDesignation(facture.getDesignation());
            facture1.setId(id);
            invoiceService.save(facture);
            return ResponseEntity.ok().body(facture1);
        }
        else
        {
            HashMap<String, String> message = new HashMap<>();
            message.put("message :", id + "  facture not found or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        }
    }
    @DeleteMapping("invoice/{id}")
    public ResponseEntity<?> deletefacture(@PathVariable Long id) {
        if (invoiceService.existsById(id)) {
            invoiceService.deletefacture(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message: facture with id: ", id + " deleted sucessfully.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message: facture with id: ", id + "  facture not found or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        }

    }
    @PostMapping("/createPdf")
    public String create(@RequestBody invoice invoice) throws IOException {
        PDDocument pdDocument=new PDDocument();
        MultipartFile multipartFile ;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Here you have to set the actual filename of your pdf


        return "hello";
    }
}
