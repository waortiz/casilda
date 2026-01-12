package com.casilda.rutavioleta.model.enums;

public enum Jornada {
    MANANA("Mañana"),
    TARDE("Tarde"),
    NA("N/A");
    
    private final String descripcion;
    
    Jornada(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}
