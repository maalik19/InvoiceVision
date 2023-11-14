package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.invoice;
import com.bezkoder.springjwt.repository.invoiceRepository;

import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class invoiceService {

    @Autowired
    private invoiceRepository invoiceRepository;
    public List<invoice> getfacture(){
        return invoiceRepository.getAllBydate();
    }

    public List<Object[]> getSumTotalTtc(){
        return invoiceRepository.getSumTotalTtc();
    }
    public Optional<invoice> getfactureById(Long id){
        return invoiceRepository.findById(id);
    }
    public invoice save(invoice facture) {
        return invoiceRepository.save(facture);
    }
    public boolean existsById (long id)
    {
        return invoiceRepository.existsById(id);
    }
    public void deletefacture(long id)
    {
        invoiceRepository.deleteById(id);
    }

    public String createPdf(invoice invoice) throws IOException {
       /* PDDocument doc=new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDPageContentStream contents = new PDPageContentStream(doc, page);
        contents.beginText();
        contents.newLineAtOffset(50, 700);
        String message="hello";

        PDFont font =PDType1Font.TIMES_ROMAN;
        contents.setFont(font, 30);
        contents.showText(message);
        contents.endText();
        contents.close();
        doc.close();*/

        return "hello";
    }
}

