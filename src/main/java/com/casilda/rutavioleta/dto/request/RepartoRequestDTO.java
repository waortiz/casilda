package com.casilda.rutavioleta.dto.request;

import com.casilda.rutavioleta.model.enums.DuplaServicio;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepartoRequestDTO {

    @NotNull(message = "El ID de la solicitud es obligatorio")
    private Long solicitudId;

    @Size(max = 150)
    private String tipoAsignacion;

    private LocalDate fechaReparto;

    @NotNull(message = "La dupla o servicio es obligatorio")
    private DuplaServicio duplaServicio;

    @Size(max = 2000)
    private String observaciones;
}
