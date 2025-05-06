# Desafio Itaú Backend (Kotlin + Spring Boot)

> Repositório com a minha solução em Kotlin e Spring Boot para o desafio de backend proposto pelo Itaú.

## 🚀 Sobre o projeto

Este projeto implementa uma API RESTful que permite o registro, consulta, remoção e cálculo de estatísticas de transações financeiras em uma janela de 60 segundos, conforme especificado no desafio do Itaú.

* Linguagem: **Kotlin 1.9.25**
* Framework: **Spring Boot 3.4.5**
* Build: **Gradle Kotlin DSL**
* Java 17, Jakarta Validation, Jackson Kotlin

## 📦 Funcionalidades

| Endpoint                  | Método | Descrição                                                                                                 |
| ------------------------- | ------ | --------------------------------------------------------------------------------------------------------- |
| `/transacao`              | POST   | Recebe `{ amount, timestamp }`. Retorna `201 Created` ou `422 Unprocessable Entity` para dados inválidos. |
| `/transacao`              | GET    | Retorna todas as transações armazenadas (últimos 60 segundos).                                            |
| `/transacao`              | DELETE | Remove todas as transações.                                                                               |
| `/transacao/estatisticas` | GET    | Retorna `{ sum, avg, max, min, count }` calculados sobre a janela de 60s.                                 |

## 📋 Como executar

1. Clone este repositório

   ```bash
   git clone https://github.com/muriloalbuquerque/itau-challenge.git
   cd itau-challenge/spring-boot
   ```

2. Execute com Gradle

   ```bash
   ./gradlew bootRun
   ```

   A aplicação iniciará em `http://localhost:8080`.

## 🔍 Exemplos de uso

### 1. Enviar transação válida

```bash
curl -X POST http://localhost:8080/transacao \
  -H "Content-Type: application/json" \
  -d '{"amount": 12.34, "timestamp": "2025-05-05T15:01:00Z"}'
# HTTP 201 Created
```

### 2. Enviar transação inválida (timestamp futuro)

```bash
curl -X POST http://localhost:8080/transacao \
  -H "Content-Type: application/json" \
  -d '{"amount": 5.00, "timestamp": "3025-01-01T00:00:00Z"}'
# HTTP 422 Unprocessable Entity
```

### 3. Consultar estatísticas

```bash
curl http://localhost:8080/transacao/estatisticas
# {
#   "sum": 123.45,
#   "avg": 12.345,
#   "max": 50.00,
#   "min": 1.23,
#   "count": 10
# }
```

### 4. Remover todas as transações

```bash
curl -X DELETE http://localhost:8080/transacao
# HTTP 204 No Content
```

## 🧪 Testes

Execute os testes automatizados (JUnit + MockMvc):

```bash
./gradlew test
```

## 📝 Estrutura do projeto

```
spring-boot/
├── src
│   ├── main
│   │   ├── kotlin
│   │   │   └── com.exemplo.itau
│   │   │       ├── controller
│   │   │       ├── model
│   │   │       ├── service
│   │   │       └── dto
│   │   └── resources
│   │       └── application.yml
│   └── test
│       └── kotlin
│           └── com.exemplo.itau
│               └── TransactionControllerTest.kt
├── build.gradle.kts
└── settings.gradle.kts
```

## ✨ Melhorias futuras

* Adicionar cache para otimizar cálculo de estatísticas.
* Persistir transações em banco de dados (PostgreSQL, Redis).
* Dockerizar a aplicação.

---

> Feito com 💜 por Murilo Albuquerque
> Contato: [muriloalbuquerquemartins@gmail.com](mailto:muriloalbuquerquemartins@gmail.com) | [LinkedIn](https://www.linkedin.com/in/murilo-albuquerque-dev/)
