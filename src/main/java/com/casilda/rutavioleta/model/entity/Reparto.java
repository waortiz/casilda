package com.casilda.rutavioleta.model.entity;

import com.casilda.rutavioleta.model.enums.DuplaServicio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "repartos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reparto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    @Column(name = "tipo_asignacion")
    private String tipoAsignacion;

    @Column(name = "fecha_reparto", nullable = false)
    private LocalDate fechaReparto;

    @Enumerated(EnumType.STRING)
    @Column(name = "dupla_servicio", nullable = false)
    private DuplaServicio duplaServicio;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    // Auditoría
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        if (fechaReparto == null) {
            fechaReparto = LocalDate.now();
        }
    }
}
