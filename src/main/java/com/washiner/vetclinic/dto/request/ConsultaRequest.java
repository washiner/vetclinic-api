package com.washiner.vetclinic.dto.request;

import com.washiner.vetclinic.domain.enums.StatusConsulta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequest(

        @NotNull(message = "Data e hora são obrigatórias")
        LocalDateTime dataHora,

        @NotBlank(message = "Motivo é obrigatório")
        String motivo,

        String diagnostico,

        @NotNull(message = "Status é obrigatório")
        StatusConsulta status,

        @NotNull(message = "Animal é obrigatório")
        Long animalId,

        @NotNull(message = "Veterinário é obrigatório")
        Long veterinarioId
) {}