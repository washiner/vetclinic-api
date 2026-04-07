# VetClinic API

API REST para gestão de clínica veterinária desenvolvida com Spring Boot.

## Tecnologias

- Java 25
- Spring Boot 4.0.5
- Spring Data JPA
- PostgreSQL
- Flyway
- Lombok
- Swagger / OpenAPI
- Docker

## Funcionalidades

- Cadastro e gestão de tutores
- Cadastro e gestão de animais
- Cadastro e gestão de veterinários
- Agendamento e gestão de consultas
- Validações de entrada com mensagens de erro descritivas
- Paginação em todas as listagens

## Como rodar localmente

### Pré-requisitos
- Java 25
- Docker

### Passos

1. Clone o repositório
   \```bash
git clone https://github.com/washiner/vetclinic-api.git
\```

2. Suba o banco de dados
   \```bash
docker compose up -d
\```

3. Rode a aplicação pela IDE ou pelo terminal
   \```bash
./mvnw spring-boot:run
\```

4. Acesse o Swagger
   \```
http://localhost:8080/swagger-ui.html
\```

## Modelagem do banco

| Entidade | Descrição |
|---|---|
| Tutor | Dono do animal |
| Animal | Paciente da clínica |
| Veterinario | Profissional que realiza a consulta |
| Consulta | Atendimento que conecta animal e veterinário |

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| GET | /tutores | Lista todos os tutores paginado |
| POST | /tutores | Cadastra novo tutor |
| GET | /tutores/{id} | Busca tutor por id |
| PUT | /tutores/{id} | Atualiza tutor |
| DELETE | /tutores/{id} | Remove tutor |
| GET | /animais | Lista todos os animais paginado |
| POST | /animais | Cadastra novo animal |
| GET | /animais/{id} | Busca animal por id |
| PUT | /animais/{id} | Atualiza animal |
| DELETE | /animais/{id} | Remove animal |
| GET | /veterinarios | Lista todos os veterinários paginado |
| POST | /veterinarios | Cadastra novo veterinário |
| GET | /veterinarios/{id} | Busca veterinário por id |
| PUT | /veterinarios/{id} | Atualiza veterinário |
| DELETE | /veterinarios/{id} | Remove veterinário |
| GET | /consultas | Lista todas as consultas paginado |
| POST | /consultas | Agenda nova consulta |
| GET | /consultas/{id} | Busca consulta por id |
| PUT | /consultas/{id} | Atualiza consulta |
| DELETE | /consultas/{id} | Remove consulta |

## Autor

Washiner Takeuchi