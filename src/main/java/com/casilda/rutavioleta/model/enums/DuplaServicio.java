package com.casilda.rutavioleta.model.enums;

public enum DuplaServicio {
    DUPLA_1("Dupla N° 1"),
    DUPLA_2("Dupla N° 2"),
    DUPLA_3("Dupla N° 3"),
    ABOGADA_1("Abogada N° 1"),
    ABOGADA_2("Abogada N° 2"),
    PSICOLOGA_1("Psicóloga N° 1"),
    PSICOLOGA_2("Psicóloga N° 2"),
    TRABAJADORA_SOCIAL_1("Trabajadora Social N° 1");
    
    private final String descripcion;
    
    DuplaServicio(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}
