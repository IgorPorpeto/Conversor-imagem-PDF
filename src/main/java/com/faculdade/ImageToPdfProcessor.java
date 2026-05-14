package com.faculdade;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ImageToPdfProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // Obtém o arquivo de imagem da mensagem Camel
        File imageFile = exchange.getIn().getBody(File.class);
        
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            // Cria a imagem para o PDF
            PDImageXObject pdImage = PDImageXObject.createFromFileByExtension(imageFile, doc);
            
            try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {
                // Desenha a imagem (ajuste de escala pode ser necessário)
                contents.drawImage(pdImage, 20, 20, 500, 700);
            }

            // Define o nome do novo arquivo (trocando a extensão para .pdf)
            String outputName = imageFile.getName().replaceAll("(?i)\\.(jpg|png|jpeg)$", ".pdf");
            
            // Enviamos o documento como um array de bytes para o Camel salvar
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            doc.save(baos);
            
            exchange.getIn().setHeader(Exchange.FILE_NAME, outputName);
            exchange.getIn().setBody(baos.toByteArray());
        }
    }
}