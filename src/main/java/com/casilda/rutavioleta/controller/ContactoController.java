package com.casilda.rutavioleta.controller;

import com.casilda.rutavioleta.dto.request.ContactoRequestDTO;
import com.casilda.rutavioleta.dto.response.ContactoResponseDTO;
import com.casilda.rutavioleta.service.ContactoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContactoController {

    private final ContactoService contactoService;

    @PostMapping
    public ResponseEntity<ContactoResponseDTO> crearContacto(
            @Valid @RequestBody ContactoRequestDTO requestDTO) {
        ContactoResponseDTO response = contactoService.crearContacto(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoResponseDTO> obtenerContactoPorId(@PathVariable Long id) {
        ContactoResponseDTO response = contactoService.obtenerContactoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/solicitud/{solicitudId}")
    public ResponseEntity<List<ContactoResponseDTO>> obtenerContactosPorSolicitud(
            @PathVariable Long solicitudId) {
        List<ContactoResponseDTO> response = contactoService.obtenerContactosPorSolicitud(solicitudId);
        return ResponseEntity.ok(response);
    }
}
