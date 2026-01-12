package com.casilda.rutavioleta.dto.request;

import com.casilda.rutavioleta.model.enums.TipoCita;
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
public class CitaRequestDTO {

    @NotNull(message = "El ID de la solicitud es obligatorio")
    private Long solicitudId;

    @NotBlank(message = "El nombre de la cita es obligatorio")
    @Size(max = 200)
    private String cita;

    @NotNull(message = "La fecha de la cita es obligatoria")
    private LocalDate fechaCita;

    @NotNull(message = "La hora de la cita es obligatoria")
    private LocalTime horaCita;

    @NotNull(message = "El tipo de cita es obligatorio")
    private TipoCita tipo;
}
