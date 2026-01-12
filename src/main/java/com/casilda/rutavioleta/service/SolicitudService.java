package com.casilda.rutavioleta.service;

import com.casilda.rutavioleta.dto.request.SolicitudRequestDTO;
import com.casilda.rutavioleta.dto.response.SolicitudResponseDTO;
import com.casilda.rutavioleta.exception.ResourceNotFoundException;
import com.casilda.rutavioleta.exception.DuplicateResourceException;
import com.casilda.rutavioleta.mapper.SolicitudMapper;
import com.casilda.rutavioleta.model.entity.Solicitud;
import com.casilda.rutavioleta.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final SolicitudMapper solicitudMapper;

    @Transactional
    public SolicitudResponseDTO crearSolicitud(SolicitudRequestDTO requestDTO) {
        // Validar que el número de documento no esté duplicado
        if (solicitudRepository.existsByNumeroDocumento(requestDTO.getNumeroDocumento())) {
            throw new DuplicateResourceException(
                "Ya existe una solicitud con el número de documento: " + requestDTO.getNumeroDocumento()
            );
        }

        Solicitud solicitud = solicitudMapper.toEntity(requestDTO);
        Solicitud savedSolicitud = solicitudRepository.save(solicitud);
        return solicitudMapper.toDTO(savedSolicitud);
    }

    @Transactional(readOnly = true)
    public SolicitudResponseDTO obtenerSolicitudPorId(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitud no encontrada con ID: " + id));
        return solicitudMapper.toDTO(solicitud);
    }

    @Transactional(readOnly = true)
    public List<SolicitudResponseDTO> obtenerTodasLasSolicitudes() {
        return solicitudRepository.findAll().stream()
                .map(solicitudMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SolicitudResponseDTO obtenerSolicitudPorNumeroDocumento(String numeroDocumento) {
        Solicitud solicitud = solicitudRepository.findByNumeroDocumento(numeroDocumento)
                .orElseThrow(() -> new ResourceNotFoundException(
                    "Solicitud no encontrada con número de documento: " + numeroDocumento
                ));
        return solicitudMapper.toDTO(solicitud);
    }

    @Transactional
    public void eliminarSolicitud(Long id) {
        if (!solicitudRepository.existsById(id)) {
            throw new ResourceNotFoundException("Solicitud no encontrada con ID: " + id);
        }
        solicitudRepository.deleteById(id);
    }
}
