# paymentRest
Serviço REST para regras de negócio de pagamentos.

## Informações
Serviço construído utilizando Java 8 juntamente com Spring-Boot para manter o servidor de aplicação.

A aplicação foi projetada como um serviço REST, acessando uma base de dados MySQL na versão 8.0, que será preparada pelo Flyway ao iniciar a aplicação.

## Preparando o ambiente de desenvolvimento do projeto
Ao clonar o repositório, será preciso baixar as dependências contidas no POM.

O projeto foi construído utilizando o Maven 3, para facilitar esta tarefa. Caso esteja utilizando a IDE Eclipse para desenvolvimento, pode utilizar o comando "mvn eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true" para baixar todas as dependências e preparar o projeto para a estrutura esperada pelo Eclipse.

Neste momento é interessante ajustar o arquivo de propriedades da aplicação com os endereços da base de dados utilizada. Será preciso atualizar o Host do banco de dados e o Schema que será utilizando, tanto para o Hibernate quando para o Flyway.

Após estas configurações, será importante executar o comando "mvn clean install", para que o Maven execute o ciclo compilação do projeto e ajuste corretamente o arquivo de propriedades para que a IDE o interprete corretamente.

Também é possível iniciar o projeto diretamente pelo console, com o comando "mvn spring-boot:run".

## Endpoints REST
Foi adicionada a dependência ao Swagger para gerar uma documentação sobre o uso da API do serviço e permitir uma visualiação prática do uso desta API.

O Swagger está configurado para ser acessado pela URL padrão: http://localhost:8080/swagger-ui.html
