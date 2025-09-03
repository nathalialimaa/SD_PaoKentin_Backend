# Paokentin - Guia de Inicialização com Docker

Este projeto é uma aplicação Spring Boot empacotada em um arquivo JAR e pronta para execução via Docker. A imagem Docker é construída usando **multi-stage**, para incluir o build do Maven dentro do container.

## Pré-requisitos

* [Docker](https://docs.docker.com/get-docker/) instalado na máquina.
* Java 17 (para builds locais, se necessário).

## Como construir e executar com Docker

1. **Build e execução com Docker (multi-stage)**:
   Não é necessário gerar o JAR manualmente; o Dockerfile já faz isso:

   ```bash
   docker build -t paokentin:1.0.0 .
   docker run --name paokentin -p 8080:8080 paokentin:1.0.0
   ```

2. A aplicação estará disponível em `http://localhost:8080`.

## Configuração do banco de dados

* A aplicação espera que as informações de conexão com o banco sejam passadas via **variáveis de ambiente**:

```text
SPRING_DATASOURCE_URL=jdbc:mysql://<HOST>:<PORT>/<DATABASE>
SPRING_DATASOURCE_USERNAME=<USERNAME>
SPRING_DATASOURCE_PASSWORD=<PASSWORD>
```

> Substitua `<HOST>`, `<PORT>`, `<DATABASE>`, `<USERNAME>` e `<PASSWORD>` pelos dados do seu MySQL (ex.: Railway ou outro serviço).

## Dockerfile utilizado

```dockerfile
# Etapa 1: build com Maven
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: runtime
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/paokentin-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## Observações

* Certifique-se de que a porta 8080 está livre.
* Para deploy em serviços externos (Render, Railway), configure as variáveis de ambiente do banco.
* O JAR gerado será automaticamente construído dentro do Docker, não sendo necessário criá-lo manualmente.
