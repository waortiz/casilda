package com.casilda.rutavioleta.service;

import com.casilda.rutavioleta.dto.request.CitaRequestDTO;
import com.casilda.rutavioleta.dto.request.ReprogramacionRequestDTO;
import com.casilda.rutavioleta.dto.response.CitaResponseDTO;
import com.casilda.rutavioleta.dto.response.ReprogramacionResponseDTO;
import com.casilda.rutavioleta.exception.ResourceNotFoundException;
import com.casilda.rutavioleta.model.entity.Cita;
import com.casilda.rutavioleta.model.entity.Reprogramacion;
import com.casilda.rutavioleta.model.entity.Solicitud;
import com.casilda.rutavioleta.repository.CitaRepository;
import com.casilda.rutavioleta.repository.ReprogramacionRepository;
import com.casilda.rutavioleta.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;
    private final SolicitudRepository solicitudRepository;
    private final ReprogramacionRepository reprogramacionRepository;

    @Transactional
    public CitaResponseDTO crearCita(CitaRequestDTO requestDTO) {
        Solicitud solicitud = solicitudRepository.findById(requestDTO.getSolicitudId())
                .orElseThrow(() -> new ResourceNotFoundException(
                    "Solicitud no encontrada con ID: " + requestDTO.getSolicitudId()
                ));

        Cita cita = new Cita();
        cita.setSolicitud(solicitud);
        cita.setCita(requestDTO.getCita());
        cita.setFechaCita(requestDTO.getFechaCita());
        cita.setHoraCita(requestDTO.getHoraCita());
        cita.setTipo(requestDTO.getTipo());

        Cita savedCita = citaRepository.save(cita);
        return toDTO(savedCita);
    }

    @Transactional(readOnly = true)
    public List<CitaResponseDTO> obtenerCitasPorSolicitud(Long solicitudId) {
        if (!solicitudRepository.existsById(solicitudId)) {
            throw new ResourceNotFoundException("Solicitud no encontrada con ID: " + solicitudId);
        }
        return citaRepository.findBySolicitudId(solicitudId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CitaResponseDTO obtenerCitaPorId(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada con ID: " + id));
        return toDTO(cita);
    }

    @Transactional
    public ReprogramacionResponseDTO reprogramarCita(Long citaId, ReprogramacionRequestDTO requestDTO) {
        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada con ID: " + citaId));

        Reprogramacion reprogramacion = new Reprogramacion();
        reprogramacion.setCita(cita);
        reprogramacion.setFechaCitaNueva(requestDTO.getFechaCitaNueva());
        reprogramacion.setHoraCitaNueva(requestDTO.getHoraCitaNueva());
        reprogramacion.setMotivo(requestDTO.getMotivo());
        reprogramacion.setObservaciones(requestDTO.getObservaciones());

        Reprogramacion savedReprogramacion = reprogramacionRepository.save(reprogramacion);

        // Actualizar la cita con la nueva fecha y hora
        cita.setFechaCita(requestDTO.getFechaCitaNueva());
        cita.setHoraCita(requestDTO.getHoraCitaNueva());
        citaRepository.save(cita);

        return toReprogramacionDTO(savedReprogramacion);
    }

    @Transactional(readOnly = true)
    public List<ReprogramacionResponseDTO> obtenerReprogramacionesPorCita(Long citaId) {
        if (!citaRepository.existsById(citaId)) {
            throw new ResourceNotFoundException("Cita no encontrada con ID: " + citaId);
        }
        return reprogramacionRepository.findByCitaId(citaId).stream()
                .map(this::toReprogramacionDTO)
                .collect(Collectors.toList());
    }

    private CitaResponseDTO toDTO(Cita cita) {
        return CitaResponseDTO.builder()
                .id(cita.getId())
                .solicitudId(cita.getSolicitud().getId())
                .cita(cita.getCita())
                .fechaCita(cita.getFechaCita())
                .horaCita(cita.getHoraCita())
                .tipo(cita.getTipo())
                .createdAt(cita.getCreatedAt())
                .updatedAt(cita.getUpdatedAt())
                .build();
    }

    private ReprogramacionResponseDTO toReprogramacionDTO(Reprogramacion reprogramacion) {
        return ReprogramacionResponseDTO.builder()
                .id(reprogramacion.getId())
                .citaId(reprogramacion.getCita().getId())
                .fechaCitaNueva(reprogramacion.getFechaCitaNueva())
                .horaCitaNueva(reprogramacion.getHoraCitaNueva())
                .motivo(reprogramacion.getMotivo())
                .observaciones(reprogramacion.getObservaciones())
                .createdAt(reprogramacion.getCreatedAt())
                .updatedAt(reprogramacion.getUpdatedAt())
                .build();
    }
}
