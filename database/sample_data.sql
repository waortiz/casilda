-- Datos de ejemplo para pruebas

-- Insertar solicitud de ejemplo
INSERT INTO solicitudes (
    tipo_solicitud, 
    primer_nombre_remitente, primer_apellido_remitente,
    campus, dependencia,
    fecha_solicitud, tipo_documento, numero_documento,
    primer_nombre_afectado, primer_apellido_afectado,
    identidad_genero, edad, celular, correo_personal
) VALUES (
    'DIRECTA',
    'Juan', 'Pérez',
    'Campus Apartadó', 'Línea Violeta',
    '2026-01-12', 'CC', '1234567890',
    'María', 'González',
    'Femenino', 25, '3001234567', 'maria@example.com'
);

-- Insertar reparto de ejemplo
INSERT INTO repartos (
    solicitud_id, tipo_asignacion, fecha_reparto, dupla_servicio, observaciones
) VALUES (
    1, 'Primera Atención', '2026-01-12', 'DUPLA_1', 'Caso asignado para evaluación inicial'
);

-- Insertar contacto de ejemplo
INSERT INTO contactos (
    solicitud_id, fecha, hora, jornada, resultado
) VALUES (
    1, '2026-01-13', '10:30:00', 'MANANA', 'CONTESTA_Y_CONCRETA_CITA'
);

-- Insertar cita de ejemplo
INSERT INTO citas (
    solicitud_id, cita, fecha_cita, hora_cita, tipo
) VALUES (
    1, 'Primera Consulta', '2026-01-15', '14:00:00', 'PRESENCIAL'
);
