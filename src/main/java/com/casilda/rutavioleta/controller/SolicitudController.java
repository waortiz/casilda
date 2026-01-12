package com.casilda.rutavioleta.controller;

import com.casilda.rutavioleta.dto.request.SolicitudRequestDTO;
import com.casilda.rutavioleta.dto.response.SolicitudResponseDTO;
import com.casilda.rutavioleta.service.SolicitudService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SolicitudController {

    private final SolicitudService solicitudService;

    @PostMapping
    public ResponseEntity<SolicitudResponseDTO> crearSolicitud(
            @Valid @RequestBody SolicitudRequestDTO requestDTO) {
        SolicitudResponseDTO response = solicitudService.crearSolicitud(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudResponseDTO> obtenerSolicitudPorId(@PathVariable Long id) {
        SolicitudResponseDTO response = solicitudService.obtenerSolicitudPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SolicitudResponseDTO>> obtenerTodasLasSolicitudes() {
        List<SolicitudResponseDTO> response = solicitudService.obtenerTodasLasSolicitudes();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<SolicitudResponseDTO> obtenerSolicitudPorNumeroDocumento(
            @PathVariable String numeroDocumento) {
        SolicitudResponseDTO response = solicitudService.obtenerSolicitudPorNumeroDocumento(numeroDocumento);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        solicitudService.eliminarSolicitud(id);
        return ResponseEntity.noContent().build();
    }
}
