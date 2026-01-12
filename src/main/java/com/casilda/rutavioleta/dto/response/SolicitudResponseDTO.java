package com.casilda.rutavioleta.dto.response;

import com.casilda.rutavioleta.model.enums.TipoDocumento;
import com.casilda.rutavioleta.model.enums.TipoSolicitud;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudResponseDTO {

    private Long id;
    private TipoSolicitud tipoSolicitud;
    
    // Datos del Remitente
    private String primerNombreRemitente;
    private String segundoNombreRemitente;
    private String primerApellidoRemitente;
    private String segundoApellidoRemitente;
    private String cargoRemitente;
    
    // Ubicación Académica
    private String campus;
    private String dependencia;
    private String facultad;
    private String otraFacultad;
    
    // Datos de la Solicitud
    private LocalDate fechaSolicitud;
    private TipoDocumento tipoDocumento;
    private String otroDocumento;
    private String numeroDocumento;
    
    // Datos de la Persona Afectada
    private String primerNombreAfectado;
    private String segundoNombreAfectado;
    private String primerApellidoAfectado;
    private String segundoApellidoAfectado;
    private String identidadGenero;
    private Integer edad;
    
    // Contacto
    private String celular;
    private String telefonoAlterno;
    private String correoInstitucional;
    private String correoPersonal;
    
    // Auditoría
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
