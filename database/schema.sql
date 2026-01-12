-- Script de inicialización de la base de datos para Ruta Violeta

-- Crear la base de datos si no existe
-- CREATE DATABASE ruta_violeta_db;

-- Conectar a la base de datos
-- \c ruta_violeta_db;

-- Las tablas serán creadas automáticamente por Hibernate
-- Este script es solo para referencia de la estructura

-- Tabla de solicitudes
CREATE TABLE IF NOT EXISTS solicitudes (
    id BIGSERIAL PRIMARY KEY,
    tipo_solicitud VARCHAR(50) NOT NULL,
    
    -- Datos del Remitente
    primer_nombre_remitente VARCHAR(100) NOT NULL,
    segundo_nombre_remitente VARCHAR(100),
    primer_apellido_remitente VARCHAR(100) NOT NULL,
    segundo_apellido_remitente VARCHAR(100),
    cargo_remitente VARCHAR(150),
    
    -- Ubicación Académica
    campus VARCHAR(150),
    dependencia VARCHAR(150),
    facultad VARCHAR(200),
    otra_facultad VARCHAR(200),
    
    -- Datos de la Solicitud
    fecha_solicitud DATE NOT NULL,
    tipo_documento VARCHAR(50) NOT NULL,
    otro_documento VARCHAR(100),
    numero_documento VARCHAR(50) NOT NULL UNIQUE,
    
    -- Datos de la Persona Afectada
    primer_nombre_afectado VARCHAR(100) NOT NULL,
    segundo_nombre_afectado VARCHAR(100),
    primer_apellido_afectado VARCHAR(100) NOT NULL,
    segundo_apellido_afectado VARCHAR(100),
    identidad_genero VARCHAR(100),
    edad INTEGER NOT NULL,
    
    -- Contacto
    celular VARCHAR(10) NOT NULL,
    telefono_alterno VARCHAR(10),
    correo_institucional VARCHAR(150),
    correo_personal VARCHAR(150),
    
    -- Auditoría
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de repartos
CREATE TABLE IF NOT EXISTS repartos (
    id BIGSERIAL PRIMARY KEY,
    solicitud_id BIGINT NOT NULL,
    tipo_asignacion VARCHAR(150),
    fecha_reparto DATE NOT NULL,
    dupla_servicio VARCHAR(50) NOT NULL,
    observaciones TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (solicitud_id) REFERENCES solicitudes(id) ON DELETE CASCADE
);

-- Tabla de contactos
CREATE TABLE IF NOT EXISTS contactos (
    id BIGSERIAL PRIMARY KEY,
    solicitud_id BIGINT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    jornada VARCHAR(50) NOT NULL,
    resultado VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (solicitud_id) REFERENCES solicitudes(id) ON DELETE CASCADE
);

-- Tabla de citas
CREATE TABLE IF NOT EXISTS citas (
    id BIGSERIAL PRIMARY KEY,
    solicitud_id BIGINT NOT NULL,
    cita VARCHAR(200) NOT NULL,
    fecha_cita DATE NOT NULL,
    hora_cita TIME NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (solicitud_id) REFERENCES solicitudes(id) ON DELETE CASCADE
);

-- Tabla de reprogramaciones
CREATE TABLE IF NOT EXISTS reprogramaciones (
    id BIGSERIAL PRIMARY KEY,
    cita_id BIGINT NOT NULL,
    fecha_cita_nueva DATE NOT NULL,
    hora_cita_nueva TIME NOT NULL,
    motivo VARCHAR(100) NOT NULL,
    observaciones TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cita_id) REFERENCES citas(id) ON DELETE CASCADE
);

-- Índices para mejorar el rendimiento
CREATE INDEX IF NOT EXISTS idx_solicitudes_numero_documento ON solicitudes(numero_documento);
CREATE INDEX IF NOT EXISTS idx_repartos_solicitud_id ON repartos(solicitud_id);
CREATE INDEX IF NOT EXISTS idx_contactos_solicitud_id ON contactos(solicitud_id);
CREATE INDEX IF NOT EXISTS idx_citas_solicitud_id ON citas(solicitud_id);
CREATE INDEX IF NOT EXISTS idx_reprogramaciones_cita_id ON reprogramaciones(cita_id);
