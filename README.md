# Paokentin - Guia de Inicialização com Docker

Este projeto é uma aplicação Spring Boot empacotada em um arquivo JAR e pronta para execução via Docker.

## Pré-requisitos

- [Docker](https://docs.docker.com/get-docker/) instalado na máquina.
- O arquivo `paokentin-1.0.0.jar` gerado na pasta `target` após o build do projeto.

## Como construir a imagem Docker

1. Gere o JAR do projeto:
  ```bash
  ./mvnw clean package
  ```
2. Construa a imagem Docker:
  ```bash
  docker build -t paokentin:1.0.0 .
  ```

## Como executar o container

```bash
docker run --name paokentin -p 8080:8080 paokentin:1.0.0
```

A aplicação estará disponível em `http://localhost:8080`.

## Dockerfile utilizado

```dockerfile
FROM openjdk:17-jdk-alpine
COPY target/paokentin-1.0.0.jar paokentin-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/paokentin-1.0.0.jar"]
```

## Observações

- Certifique-se de que a porta 8080 está livre.
- Ajuste o nome do JAR caso necessário.
