Image to PDF Converter (Spring Boot + Apache Camel)

Este projeto é uma aplicação de integração desenvolvida em Java que utiliza o Apache Camel para monitorar um diretório de arquivos e converter automaticamente imagens (JPG, JPEG, PNG) para o formato PDF utilizando a biblioteca Apache PDFBox.

O projeto foi desenvolvido como parte das atividades da disciplina de Redes/Integração de Sistemas.
🚀 Funcionalidades

    Monitoramento Automático: O Apache Camel "escuta" uma pasta de entrada em tempo real.

    Filtragem de Arquivos: Processa apenas arquivos com extensões de imagem permitidas.

    Transformação de Dados: Converte o binário da imagem em um documento PDF formatado.

    Gestão de Fluxo: Utiliza estratégias de pós-processamento para evitar duplicidade e manter a organização.

🛠️ Tecnologias Utilizadas

    Java 21

    Spring Boot 3.2.0: Framework base da aplicação.

    Apache Camel 4.2.0: Orquestração de rotas e integração.

    Apache PDFBox: Manipulação e geração de documentos PDF.

    Maven: Gerenciamento de dependências.

📋 Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

    JDK 21 ou superior.

    Maven.

    Uma IDE de sua preferência (Eclipse, VS Code, IntelliJ).

🔧 Configuração e Execução
1. Clonar o repositório
Bash

git clone https://github.com/seu-usuario/conversor-imagem-pdf.git
cd conversor-imagem-pdf

2. Ajustar os caminhos das pastas

No arquivo src/main/java/com/faculdade/route/ImageRoute.java, altere os caminhos para diretórios existentes em sua máquina:
Java

from("file:"COLOQUE AQUI A PASTA ONDE SERA COLOCADA A IMAGEM A SER CONVERTIDA (ENTRADA)"?include=.*\\.(jpg|png)$&noop=true") // Exemplo: E:/seu-caminho/entrada
// ...
.to("file:"COLOQUE AQUI A PASTA DA IMAGEM CONVERTIDA (SAIDA)"") // Exemplo: E:/seu-caminho/saida

3. Rodar a aplicação

Pelo terminal:
Bash

mvn spring-boot:run

Ou execute a classe Application.java diretamente pela sua IDE.
📖 Como Usar

    Com a aplicação rodando, navegue até a pasta definida como entrada.

    Cole qualquer imagem nos formatos .jpg, .jpeg ou .png.

    O sistema detectará o arquivo instantaneamente.

    Verifique a pasta definida como saida para encontrar o arquivo .pdf gerado.

🏗️ Estrutura do Projeto

    Application.java: Ponto de entrada do Spring Boot.

    ImageRoute.java: Definição da rota do Camel (DSL).

    ImageToPdfProcessor.java: Lógica de conversão utilizando PDFBox.

    application.properties: Configurações de tempo de execução do Camel.

👤 Autor

Desenvolvido por Igor Porpeto.