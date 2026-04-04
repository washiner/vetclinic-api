package com.washiner.vetclinic.dto.response;

import com.washiner.vetclinic.domain.entity.Consulta;
import com.washiner.vetclinic.domain.enums.StatusConsulta;

import java.time.LocalDateTime;

public record ConsultaResponse(
        Long id,
        LocalDateTime dataHora,
        String motivo,
        String diagnostico,
        StatusConsulta status,
        String nomeAnimal,
        String nomeVeterinario
) {
    public static ConsultaResponse from(Consulta consulta) {
        return new ConsultaResponse(
                consulta.getId(),
                consulta.getDataHora(),
                consulta.getMotivo(),
                consulta.getDiagnostico(),
                consulta.getStatus(),
                consulta.getAnimal().getNome(),
                consulta.getVeterinario().getNome()
        );
    }
}