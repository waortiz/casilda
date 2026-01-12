package com.casilda.rutavioleta.repository;

import com.casilda.rutavioleta.model.entity.Reparto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepartoRepository extends JpaRepository<Reparto, Long> {
    
    List<Reparto> findBySolicitudId(Long solicitudId);
}
