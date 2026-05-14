package com.faculdade;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ImageRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Monitora a pasta 'entrada', processa imagens e joga em 'saida'
    	from("file:"COLOQUE AQUI A PASTA ONDE SERA COLOCADA A IMAGEM A SER CONVERTIDA (ENTRADA)"?" +
    		"include=.*\\.(jpg|jpeg|png)$&move=processados") // Exemplo: E:/seu-caminho/entrada
            .routeId("rota-transformacao-imagem")
            .log("Processando arquivo: ${header.CamelFileName}")
            .process("imageToPdfProcessor") // Chama o nosso processador
            .to("file:"COLOQUE AQUI A PASTA DA IMAGEM CONVERTIDA (SAIDA)"") // Exemplo: E:/seu-caminho/saida
            .log("PDF gerado com sucesso na pasta de saída!");
    }
}
