package com.casilda.rutavioleta.dto.response;

import com.casilda.rutavioleta.model.enums.TipoCita;
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
public class CitaResponseDTO {

    private Long id;
    private Long solicitudId;
    private String cita;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private TipoCita tipo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
