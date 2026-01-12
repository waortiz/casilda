package com.casilda.rutavioleta.dto.request;

import com.casilda.rutavioleta.model.enums.Jornada;
import com.casilda.rutavioleta.model.enums.ResultadoContacto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactoRequestDTO {

    @NotNull(message = "El ID de la solicitud es obligatorio")
    private Long solicitudId;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "La hora es obligatoria")
    private LocalTime hora;

    @NotNull(message = "La jornada es obligatoria")
    private Jornada jornada;

    @NotNull(message = "El resultado es obligatorio")
    private ResultadoContacto resultado;
}
