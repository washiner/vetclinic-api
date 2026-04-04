package com.washiner.vetclinic.dto.request;

import com.washiner.vetclinic.domain.enums.Especie;
import com.washiner.vetclinic.domain.enums.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record AnimalRequest(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull(message = "Espécie é obrigatória")
        Especie especie,

        String raca,

        @NotNull(message = "Data de nascimento é obrigatória")
        @Past(message = "Data de nascimento deve ser no passado")
        LocalDate dataNascimento,

        @NotNull(message = "Sexo é obrigatório")
        Sexo sexo,

        @NotNull(message = "Tutor é obrigatório")
        Long tutorId
) {}