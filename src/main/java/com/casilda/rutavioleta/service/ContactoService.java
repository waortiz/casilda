package com.casilda.rutavioleta.service;

import com.casilda.rutavioleta.dto.request.ContactoRequestDTO;
import com.casilda.rutavioleta.dto.response.ContactoResponseDTO;
import com.casilda.rutavioleta.exception.ResourceNotFoundException;
import com.casilda.rutavioleta.model.entity.Contacto;
import com.casilda.rutavioleta.model.entity.Solicitud;
import com.casilda.rutavioleta.repository.ContactoRepository;
import com.casilda.rutavioleta.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactoService {

    private final ContactoRepository contactoRepository;
    private final SolicitudRepository solicitudRepository;

    @Transactional
    public ContactoResponseDTO crearContacto(ContactoRequestDTO requestDTO) {
        Solicitud solicitud = solicitudRepository.findById(requestDTO.getSolicitudId())
                .orElseThrow(() -> new ResourceNotFoundException(
                    "Solicitud no encontrada con ID: " + requestDTO.getSolicitudId()
                ));

        Contacto contacto = new Contacto();
        contacto.setSolicitud(solicitud);
        contacto.setFecha(requestDTO.getFecha());
        contacto.setHora(requestDTO.getHora());
        contacto.setJornada(requestDTO.getJornada());
        contacto.setResultado(requestDTO.getResultado());

        Contacto savedContacto = contactoRepository.save(contacto);
        return toDTO(savedContacto);
    }

    @Transactional(readOnly = true)
    public List<ContactoResponseDTO> obtenerContactosPorSolicitud(Long solicitudId) {
        if (!solicitudRepository.existsById(solicitudId)) {
            throw new ResourceNotFoundException("Solicitud no encontrada con ID: " + solicitudId);
        }
        return contactoRepository.findBySolicitudId(solicitudId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContactoResponseDTO obtenerContactoPorId(Long id) {
        Contacto contacto = contactoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contacto no encontrado con ID: " + id));
        return toDTO(contacto);
    }

    private ContactoResponseDTO toDTO(Contacto contacto) {
        return ContactoResponseDTO.builder()
                .id(contacto.getId())
                .solicitudId(contacto.getSolicitud().getId())
                .fecha(contacto.getFecha())
                .hora(contacto.getHora())
                .jornada(contacto.getJornada())
                .resultado(contacto.getResultado())
                .createdAt(contacto.getCreatedAt())
                .updatedAt(contacto.getUpdatedAt())
                .build();
    }
}
