# TSI4M-LogAPI

Microserviço responsável por receber eventos de operações de carros da LojaCarro via RabbitMQ e armazená-los no MySQL.

## Tecnologias
- Java 17
- Spring Boot 3.5.7
- Spring AMQP / RabbitMQ
- Spring Data JPA
- MySQL

## Configuração

Crie o banco de dados:

```sql
CREATE DATABASE logs;
```

Configure as variáveis de ambiente se necessário:
- `DB_URL` (padrão: jdbc:mysql://localhost:3306/logs)
- `DB_USERNAME` (padrão: root)
- `DB_PASSWORD` (padrão: root)
- `RABBITMQ_HOST` (padrão: localhost)
- `RABBITMQ_PORT` (padrão: 5672)
- `RABBITMQ_USERNAME` (padrão: guest)
- `RABBITMQ_PASSWORD` (padrão: guest)

O microserviço declara a fila durável `loja.carro.logs`, a exchange `loja.carro.exchange` e a chave `loja.carro.log`. Esses nomes correspondem ao publicador do projeto LojaCarro.

## Executar

```bash
mvn spring-boot:run
```

O serviço inicia na porta 8082 e recebe as mensagens automaticamente.

## Consultar os logs

```http
GET http://localhost:8082/logs
```
