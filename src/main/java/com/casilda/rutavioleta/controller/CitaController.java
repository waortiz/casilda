package com.casilda.rutavioleta.controller;

import com.casilda.rutavioleta.dto.request.CitaRequestDTO;
import com.casilda.rutavioleta.dto.request.ReprogramacionRequestDTO;
import com.casilda.rutavioleta.dto.response.CitaResponseDTO;
import com.casilda.rutavioleta.dto.response.ReprogramacionResponseDTO;
import com.casilda.rutavioleta.service.CitaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CitaController {

    private final CitaService citaService;

    @PostMapping
    public ResponseEntity<CitaResponseDTO> crearCita(
            @Valid @RequestBody CitaRequestDTO requestDTO) {
        CitaResponseDTO response = citaService.crearCita(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponseDTO> obtenerCitaPorId(@PathVariable Long id) {
        CitaResponseDTO response = citaService.obtenerCitaPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/solicitud/{solicitudId}")
    public ResponseEntity<List<CitaResponseDTO>> obtenerCitasPorSolicitud(
            @PathVariable Long solicitudId) {
        List<CitaResponseDTO> response = citaService.obtenerCitasPorSolicitud(solicitudId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/reprogramar")
    public ResponseEntity<ReprogramacionResponseDTO> reprogramarCita(
            @PathVariable Long id,
            @Valid @RequestBody ReprogramacionRequestDTO requestDTO) {
        ReprogramacionResponseDTO response = citaService.reprogramarCita(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/reprogramaciones")
    public ResponseEntity<List<ReprogramacionResponseDTO>> obtenerReprogramacionesPorCita(
            @PathVariable Long id) {
        List<ReprogramacionResponseDTO> response = citaService.obtenerReprogramacionesPorCita(id);
        return ResponseEntity.ok(response);
    }
}
