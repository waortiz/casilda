package com.casilda.rutavioleta.model.entity;

import com.casilda.rutavioleta.model.enums.TipoDocumento;
import com.casilda.rutavioleta.model.enums.TipoSolicitud;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "solicitudes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_solicitud", nullable = false)
    private TipoSolicitud tipoSolicitud;

    // Datos del Remitente
    @Column(name = "primer_nombre_remitente", nullable = false)
    private String primerNombreRemitente;

    @Column(name = "segundo_nombre_remitente")
    private String segundoNombreRemitente;

    @Column(name = "primer_apellido_remitente", nullable = false)
    private String primerApellidoRemitente;

    @Column(name = "segundo_apellido_remitente")
    private String segundoApellidoRemitente;

    @Column(name = "cargo_remitente")
    private String cargoRemitente;

    // Ubicación Académica
    @Column(name = "campus")
    private String campus;

    @Column(name = "dependencia")
    private String dependencia;

    @Column(name = "facultad")
    private String facultad;

    @Column(name = "otra_facultad")
    private String otraFacultad;

    // Datos de la Solicitud
    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDate fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "otro_documento")
    private String otroDocumento;

    @Column(name = "numero_documento", nullable = false, unique = true)
    private String numeroDocumento;

    // Datos de la Persona Afectada
    @Column(name = "primer_nombre_afectado", nullable = false)
    private String primerNombreAfectado;

    @Column(name = "segundo_nombre_afectado")
    private String segundoNombreAfectado;

    @Column(name = "primer_apellido_afectado", nullable = false)
    private String primerApellidoAfectado;

    @Column(name = "segundo_apellido_afectado")
    private String segundoApellidoAfectado;

    @Column(name = "identidad_genero")
    private String identidadGenero;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    // Contacto
    @Column(name = "celular", nullable = false)
    private String celular;

    @Column(name = "telefono_alterno")
    private String telefonoAlterno;

    @Column(name = "correo_institucional")
    private String correoInstitucional;

    @Column(name = "correo_personal")
    private String correoPersonal;

    // Relaciones
    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reparto> repartos = new ArrayList<>();

    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contacto> contactos = new ArrayList<>();

    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas = new ArrayList<>();

    // Auditoría
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
