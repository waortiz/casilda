package com.casilda.rutavioleta.model.enums;

public enum TipoCita {
    PRESENCIAL("Presencial"),
    VIRTUAL("Virtual"),
    TELEFONICA("Telefónica");
    
    private final String descripcion;
    
    TipoCita(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}
