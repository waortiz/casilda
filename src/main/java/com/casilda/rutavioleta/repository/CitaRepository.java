package com.casilda.rutavioleta.repository;

import com.casilda.rutavioleta.model.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    
    List<Cita> findBySolicitudId(Long solicitudId);
}
