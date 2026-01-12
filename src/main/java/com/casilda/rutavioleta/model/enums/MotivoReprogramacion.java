package com.casilda.rutavioleta.model.enums;

public enum MotivoReprogramacion {
    INASISTENCIA_INJUSTIFICADA("Inasistencia injustificada"),
    CAMBIO_AGENDA_DUPLA("Cambio de agenda de la dupla o profesional"),
    CIRCUNSTANCIAS_EXTERNAS("Circunstancias externas"),
    SOLICITUD_PERSONA_ATENDER("Solicitud de la persona a atender");
    
    private final String descripcion;
    
    MotivoReprogramacion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}
