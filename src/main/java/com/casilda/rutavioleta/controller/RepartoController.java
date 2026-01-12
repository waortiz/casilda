package com.casilda.rutavioleta.controller;

import com.casilda.rutavioleta.dto.request.RepartoRequestDTO;
import com.casilda.rutavioleta.dto.response.RepartoResponseDTO;
import com.casilda.rutavioleta.service.RepartoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repartos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RepartoController {

    private final RepartoService repartoService;

    @PostMapping
    public ResponseEntity<RepartoResponseDTO> crearReparto(
            @Valid @RequestBody RepartoRequestDTO requestDTO) {
        RepartoResponseDTO response = repartoService.crearReparto(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepartoResponseDTO> obtenerRepartoPorId(@PathVariable Long id) {
        RepartoResponseDTO response = repartoService.obtenerRepartoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/solicitud/{solicitudId}")
    public ResponseEntity<List<RepartoResponseDTO>> obtenerRepartosPorSolicitud(
            @PathVariable Long solicitudId) {
        List<RepartoResponseDTO> response = repartoService.obtenerRepartosPorSolicitud(solicitudId);
        return ResponseEntity.ok(response);
    }
}
