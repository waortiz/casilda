package com.casilda.rutavioleta.dto.request;

import com.casilda.rutavioleta.model.enums.TipoDocumento;
import com.casilda.rutavioleta.model.enums.TipoSolicitud;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudRequestDTO {

    @NotNull(message = "El tipo de solicitud es obligatorio")
    private TipoSolicitud tipoSolicitud;

    // Datos del Remitente
    @NotBlank(message = "El primer nombre del remitente es obligatorio")
    @Size(max = 100)
    private String primerNombreRemitente;

    @Size(max = 100)
    private String segundoNombreRemitente;

    @NotBlank(message = "El primer apellido del remitente es obligatorio")
    @Size(max = 100)
    private String primerApellidoRemitente;

    @Size(max = 100)
    private String segundoApellidoRemitente;

    @Size(max = 150)
    private String cargoRemitente;

    // Ubicación Académica
    @Size(max = 150)
    private String campus;

    @Size(max = 150)
    private String dependencia;

    @Size(max = 200)
    private String facultad;

    @Size(max = 200)
    private String otraFacultad;

    // Datos de la Solicitud
    @NotNull(message = "La fecha de solicitud es obligatoria")
    private LocalDate fechaSolicitud;

    @NotNull(message = "El tipo de documento es obligatorio")
    private TipoDocumento tipoDocumento;

    @Size(max = 100)
    private String otroDocumento;

    @NotBlank(message = "El número de documento es obligatorio")
    @Size(max = 50)
    private String numeroDocumento;

    // Datos de la Persona Afectada
    @NotBlank(message = "El primer nombre del afectado es obligatorio")
    @Size(max = 100)
    private String primerNombreAfectado;

    @Size(max = 100)
    private String segundoNombreAfectado;

    @NotBlank(message = "El primer apellido del afectado es obligatorio")
    @Size(max = 100)
    private String primerApellidoAfectado;

    @Size(max = 100)
    private String segundoApellidoAfectado;

    @Size(max = 100)
    private String identidadGenero;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad debe ser un valor positivo")
    @Max(value = 150, message = "La edad no puede ser mayor a 150")
    private Integer edad;

    // Contacto
    @NotBlank(message = "El celular es obligatorio")
    @Pattern(regexp = "^[0-9]{10}$", message = "El celular debe tener 10 dígitos")
    private String celular;

    @Pattern(regexp = "^[0-9]{7,10}$", message = "El teléfono alterno debe tener entre 7 y 10 dígitos")
    private String telefonoAlterno;

    @Email(message = "El correo institucional debe ser válido")
    @Size(max = 150)
    private String correoInstitucional;

    @Email(message = "El correo personal debe ser válido")
    @Size(max = 150)
    private String correoPersonal;
}
