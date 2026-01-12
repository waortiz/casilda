package com.casilda.rutavioleta.mapper;

import com.casilda.rutavioleta.dto.request.SolicitudRequestDTO;
import com.casilda.rutavioleta.dto.response.SolicitudResponseDTO;
import com.casilda.rutavioleta.model.entity.Solicitud;
import org.springframework.stereotype.Component;

@Component
public class SolicitudMapper {

    public Solicitud toEntity(SolicitudRequestDTO dto) {
        Solicitud solicitud = new Solicitud();
        solicitud.setTipoSolicitud(dto.getTipoSolicitud());
        
        // Datos del Remitente
        solicitud.setPrimerNombreRemitente(dto.getPrimerNombreRemitente());
        solicitud.setSegundoNombreRemitente(dto.getSegundoNombreRemitente());
        solicitud.setPrimerApellidoRemitente(dto.getPrimerApellidoRemitente());
        solicitud.setSegundoApellidoRemitente(dto.getSegundoApellidoRemitente());
        solicitud.setCargoRemitente(dto.getCargoRemitente());
        
        // Ubicación Académica
        solicitud.setCampus(dto.getCampus());
        solicitud.setDependencia(dto.getDependencia());
        solicitud.setFacultad(dto.getFacultad());
        solicitud.setOtraFacultad(dto.getOtraFacultad());
        
        // Datos de la Solicitud
        solicitud.setFechaSolicitud(dto.getFechaSolicitud());
        solicitud.setTipoDocumento(dto.getTipoDocumento());
        solicitud.setOtroDocumento(dto.getOtroDocumento());
        solicitud.setNumeroDocumento(dto.getNumeroDocumento());
        
        // Datos de la Persona Afectada
        solicitud.setPrimerNombreAfectado(dto.getPrimerNombreAfectado());
        solicitud.setSegundoNombreAfectado(dto.getSegundoNombreAfectado());
        solicitud.setPrimerApellidoAfectado(dto.getPrimerApellidoAfectado());
        solicitud.setSegundoApellidoAfectado(dto.getSegundoApellidoAfectado());
        solicitud.setIdentidadGenero(dto.getIdentidadGenero());
        solicitud.setEdad(dto.getEdad());
        
        // Contacto
        solicitud.setCelular(dto.getCelular());
        solicitud.setTelefonoAlterno(dto.getTelefonoAlterno());
        solicitud.setCorreoInstitucional(dto.getCorreoInstitucional());
        solicitud.setCorreoPersonal(dto.getCorreoPersonal());
        
        return solicitud;
    }

    public SolicitudResponseDTO toDTO(Solicitud entity) {
        return SolicitudResponseDTO.builder()
                .id(entity.getId())
                .tipoSolicitud(entity.getTipoSolicitud())
                .primerNombreRemitente(entity.getPrimerNombreRemitente())
                .segundoNombreRemitente(entity.getSegundoNombreRemitente())
                .primerApellidoRemitente(entity.getPrimerApellidoRemitente())
                .segundoApellidoRemitente(entity.getSegundoApellidoRemitente())
                .cargoRemitente(entity.getCargoRemitente())
                .campus(entity.getCampus())
                .dependencia(entity.getDependencia())
                .facultad(entity.getFacultad())
                .otraFacultad(entity.getOtraFacultad())
                .fechaSolicitud(entity.getFechaSolicitud())
                .tipoDocumento(entity.getTipoDocumento())
                .otroDocumento(entity.getOtroDocumento())
                .numeroDocumento(entity.getNumeroDocumento())
                .primerNombreAfectado(entity.getPrimerNombreAfectado())
                .segundoNombreAfectado(entity.getSegundoNombreAfectado())
                .primerApellidoAfectado(entity.getPrimerApellidoAfectado())
                .segundoApellidoAfectado(entity.getSegundoApellidoAfectado())
                .identidadGenero(entity.getIdentidadGenero())
                .edad(entity.getEdad())
                .celular(entity.getCelular())
                .telefonoAlterno(entity.getTelefonoAlterno())
                .correoInstitucional(entity.getCorreoInstitucional())
                .correoPersonal(entity.getCorreoPersonal())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
