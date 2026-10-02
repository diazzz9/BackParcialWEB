# University Catalog API — Spring Boot

REST API to manage a university's **faculties** and **academic programs**. Built with Spring Boot 3, Spring Data JPA and an H2 database, following a clean `controller → service → repository` layered architecture.

> Frontend: [FrontParcialWEB](https://github.com/diazzz9/FrontParcialWEB) (Angular 21)

## Tech stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.2 (Web, Data JPA, DevTools) |
| Persistence | Hibernate / JPA · H2 (in-memory, seeded with `data.sql`) |
| Utilities | Lombok · Maven Wrapper |

## Architecture

```
src/main/java/com/parcial/web
├── controller/   FacultadController      → REST endpoints (CORS enabled)
├── service/      FacultadService         → business logic
├── repository/   FacultadRepository      → Spring Data JPA
│                 ProgramaAcademicoRepository
└── entity/       Facultad                → id, nombre, decano, ubicacion
                  ProgramaAcademico       → id, nombre, nivel, duracionSemestres, @ManyToOne facultad
```

## API

Base URL: `http://localhost:8080/api/facultades`

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/facultades` | List all faculties |
| `GET` | `/api/facultades/{id}` | Get one faculty (`404` if not found) |
| `POST` | `/api/facultades` | Create a faculty |
| `PUT` | `/api/facultades/{id}` | Update a faculty |
| `DELETE` | `/api/facultades/{id}` | Delete a faculty |

Example:

```bash
curl -X POST http://localhost:8080/api/facultades \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Facultad de Ciencias","decano":"María Rojas","ubicacion":"Bloque D"}'
```

## Run locally

```bash
./mvnw spring-boot:run
```

- API → `http://localhost:8080/api/facultades`
- H2 console → `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:testdb`, user `sa`, no password)

The database is seeded on startup with three sample faculties (`src/main/resources/data.sql`).

## Evidence

Screenshots of the running API are in [`evidencias/`](evidencias).
