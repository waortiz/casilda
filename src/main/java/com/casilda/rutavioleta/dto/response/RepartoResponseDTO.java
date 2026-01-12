package com.casilda.rutavioleta.dto.response;

import com.casilda.rutavioleta.model.enums.DuplaServicio;
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
public class RepartoResponseDTO {

    private Long id;
    private Long solicitudId;
    private String tipoAsignacion;
    private LocalDate fechaReparto;
    private DuplaServicio duplaServicio;
    private String observaciones;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
