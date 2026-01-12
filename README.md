# Ruta Violeta Backend

Backend para el sistema de gestión de la Ruta Violeta desarrollado con Spring Boot y PostgreSQL.

## Requisitos

- Java 17 o superior
- Maven 3.6+
- PostgreSQL 12+

## Configuración de Base de Datos

1. Instalar PostgreSQL
2. Crear la base de datos:
```sql
CREATE DATABASE ruta_violeta_db;
```

3. Configurar credenciales en `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/ruta_violeta_db
    username: postgres
    password: postgres
```

## Instalación y Ejecución

### Compilar el proyecto
```bash
mvn clean install
```

### Ejecutar la aplicación
```bash
mvn spring-boot:run
```

La aplicación se iniciará en `http://localhost:8080/api/v1`

## Endpoints Disponibles

### Módulo de Solicitudes
- `POST /api/v1/solicitudes` - Crear nueva solicitud
- `GET /api/v1/solicitudes` - Obtener todas las solicitudes
- `GET /api/v1/solicitudes/{id}` - Obtener solicitud por ID
- `GET /api/v1/solicitudes/documento/{numeroDocumento}` - Obtener por número de documento
- `DELETE /api/v1/solicitudes/{id}` - Eliminar solicitud

### Módulo de Repartos
- `POST /api/v1/repartos` - Crear nuevo reparto
- `GET /api/v1/repartos/{id}` - Obtener reparto por ID
- `GET /api/v1/repartos/solicitud/{solicitudId}` - Obtener repartos por solicitud

### Módulo de Contactos
- `POST /api/v1/contactos` - Registrar nuevo contacto
- `GET /api/v1/contactos/{id}` - Obtener contacto por ID
- `GET /api/v1/contactos/solicitud/{solicitudId}` - Obtener contactos por solicitud

### Módulo de Citas
- `POST /api/v1/citas` - Crear nueva cita
- `GET /api/v1/citas/{id}` - Obtener cita por ID
- `GET /api/v1/citas/solicitud/{solicitudId}` - Obtener citas por solicitud
- `PUT /api/v1/citas/{id}/reprogramar` - Reprogramar cita
- `GET /api/v1/citas/{id}/reprogramaciones` - Obtener historial de reprogramaciones

## Ejemplo de Solicitud POST

```json
{
  "tipoSolicitud": "DIRECTA",
  "primerNombreRemitente": "Juan",
  "primerApellidoRemitente": "Pérez",
  "campus": "Campus Apartadó",
  "dependencia": "Línea Violeta",
  "fechaSolicitud": "2026-01-12",
  "tipoDocumento": "CC",
  "numeroDocumento": "1234567890",
  "primerNombreAfectado": "María",
  "primerApellidoAfectado": "González",
  "identidadGenero": "Femenino",
  "edad": 25,
  "celular": "3001234567",
  "correoPersonal": "maria@example.com"
}
```

## Estructura del Proyecto

```
src/main/java/com/casilda/rutavioleta/
├── controller/          # Controladores REST
├── dto/
│   ├── request/        # DTOs de entrada
│   └── response/       # DTOs de salida
├── exception/          # Manejo de excepciones
├── mapper/             # Conversores Entity-DTO
├── model/
│   ├── entity/         # Entidades JPA
│   └── enums/          # Enumeraciones
├── repository/         # Repositorios JPA
└── service/            # Lógica de negocio
```

## Tecnologías Utilizadas

- Spring Boot 3.2.1
- Spring Data JPA
- PostgreSQL
- Lombok
- Bean Validation
- Maven

## Validaciones Implementadas

- Campos obligatorios marcados con `@NotNull` y `@NotBlank`
- Validación de formato de email
- Validación de números de teléfono (10 dígitos para celular)
- Validación de edad (0-150)
- Validación de duplicados en número de documento

## Manejo de Errores

El sistema maneja los siguientes tipos de errores:

- **400 Bad Request**: Errores de validación
- **404 Not Found**: Recurso no encontrado
- **409 Conflict**: Recurso duplicado
- **500 Internal Server Error**: Error interno del servidor

## Autor

Proyecto desarrollado para el sistema de gestión de la Ruta Violeta.
