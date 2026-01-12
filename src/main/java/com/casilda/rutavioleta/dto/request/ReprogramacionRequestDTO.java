package com.casilda.rutavioleta.dto.request;

import com.casilda.rutavioleta.model.enums.MotivoReprogramacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReprogramacionRequestDTO {

    @NotNull(message = "La fecha de la cita nueva es obligatoria")
    private LocalDate fechaCitaNueva;

    @NotNull(message = "La hora de la cita nueva es obligatoria")
    private LocalTime horaCitaNueva;

    @NotNull(message = "El motivo es obligatorio")
    private MotivoReprogramacion motivo;

    @NotBlank(message = "Las observaciones son obligatorias")
    @Size(max = 2000)
    private String observaciones;
}
