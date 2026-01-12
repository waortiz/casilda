package com.casilda.rutavioleta.repository;

import com.casilda.rutavioleta.model.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    
    Optional<Solicitud> findByNumeroDocumento(String numeroDocumento);
    
    boolean existsByNumeroDocumento(String numeroDocumento);
}
