package com.casilda.rutavioleta.repository;

import com.casilda.rutavioleta.model.entity.Reprogramacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReprogramacionRepository extends JpaRepository<Reprogramacion, Long> {
    
    List<Reprogramacion> findByCitaId(Long citaId);
}
