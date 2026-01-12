package com.casilda.rutavioleta.repository;

import com.casilda.rutavioleta.model.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    
    List<Contacto> findBySolicitudId(Long solicitudId);
}
