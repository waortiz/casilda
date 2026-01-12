package com.casilda.rutavioleta.service;

import com.casilda.rutavioleta.dto.request.RepartoRequestDTO;
import com.casilda.rutavioleta.dto.response.RepartoResponseDTO;
import com.casilda.rutavioleta.exception.ResourceNotFoundException;
import com.casilda.rutavioleta.model.entity.Reparto;
import com.casilda.rutavioleta.model.entity.Solicitud;
import com.casilda.rutavioleta.repository.RepartoRepository;
import com.casilda.rutavioleta.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepartoService {

    private final RepartoRepository repartoRepository;
    private final SolicitudRepository solicitudRepository;

    @Transactional
    public RepartoResponseDTO crearReparto(RepartoRequestDTO requestDTO) {
        Solicitud solicitud = solicitudRepository.findById(requestDTO.getSolicitudId())
                .orElseThrow(() -> new ResourceNotFoundException(
                    "Solicitud no encontrada con ID: " + requestDTO.getSolicitudId()
                ));

        Reparto reparto = new Reparto();
        reparto.setSolicitud(solicitud);
        reparto.setTipoAsignacion(requestDTO.getTipoAsignacion());
        reparto.setFechaReparto(requestDTO.getFechaReparto() != null ? 
            requestDTO.getFechaReparto() : LocalDate.now());
        reparto.setDuplaServicio(requestDTO.getDuplaServicio());
        reparto.setObservaciones(requestDTO.getObservaciones());

        Reparto savedReparto = repartoRepository.save(reparto);
        return toDTO(savedReparto);
    }

    @Transactional(readOnly = true)
    public List<RepartoResponseDTO> obtenerRepartosPorSolicitud(Long solicitudId) {
        if (!solicitudRepository.existsById(solicitudId)) {
            throw new ResourceNotFoundException("Solicitud no encontrada con ID: " + solicitudId);
        }
        return repartoRepository.findBySolicitudId(solicitudId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RepartoResponseDTO obtenerRepartoPorId(Long id) {
        Reparto reparto = repartoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reparto no encontrado con ID: " + id));
        return toDTO(reparto);
    }

    private RepartoResponseDTO toDTO(Reparto reparto) {
        return RepartoResponseDTO.builder()
                .id(reparto.getId())
                .solicitudId(reparto.getSolicitud().getId())
                .tipoAsignacion(reparto.getTipoAsignacion())
                .fechaReparto(reparto.getFechaReparto())
                .duplaServicio(reparto.getDuplaServicio())
                .observaciones(reparto.getObservaciones())
                .createdAt(reparto.getCreatedAt())
                .updatedAt(reparto.getUpdatedAt())
                .build();
    }
}
