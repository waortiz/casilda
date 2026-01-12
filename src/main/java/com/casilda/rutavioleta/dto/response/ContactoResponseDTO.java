package com.casilda.rutavioleta.dto.response;

import com.casilda.rutavioleta.model.enums.Jornada;
import com.casilda.rutavioleta.model.enums.ResultadoContacto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactoResponseDTO {

    private Long id;
    private Long solicitudId;
    private LocalDate fecha;
    private LocalTime hora;
    private Jornada jornada;
    private ResultadoContacto resultado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
