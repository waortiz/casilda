package com.casilda.rutavioleta.dto.response;

import com.casilda.rutavioleta.model.enums.MotivoReprogramacion;
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
public class ReprogramacionResponseDTO {

    private Long id;
    private Long citaId;
    private LocalDate fechaCitaNueva;
    private LocalTime horaCitaNueva;
    private MotivoReprogramacion motivo;
    private String observaciones;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
