package com.casilda.rutavioleta.model.entity;

import com.casilda.rutavioleta.model.enums.MotivoReprogramacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "reprogramaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reprogramacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cita_id", nullable = false)
    private Cita cita;

    @Column(name = "fecha_cita_nueva", nullable = false)
    private LocalDate fechaCitaNueva;

    @Column(name = "hora_cita_nueva", nullable = false)
    private LocalTime horaCitaNueva;

    @Enumerated(EnumType.STRING)
    @Column(name = "motivo", nullable = false)
    private MotivoReprogramacion motivo;

    @Column(name = "observaciones", columnDefinition = "TEXT", nullable = false)
    private String observaciones;

    // Auditoría
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
