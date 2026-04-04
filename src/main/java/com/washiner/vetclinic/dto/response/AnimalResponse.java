package com.washiner.vetclinic.dto.response;

import com.washiner.vetclinic.domain.entity.Animal;
import com.washiner.vetclinic.domain.enums.Especie;
import com.washiner.vetclinic.domain.enums.Sexo;

import java.time.LocalDate;

public record AnimalResponse(
        Long id,
        String nome,
        Especie especie,
        String raca,
        LocalDate dataNascimento,
        Sexo sexo,
        String nomeTutor
) {
    public static AnimalResponse from(Animal animal) {
        return new AnimalResponse(
                animal.getId(),
                animal.getNome(),
                animal.getEspecie(),
                animal.getRaca(),
                animal.getDataNascimento(),
                animal.getSexo(),
                animal.getTutor().getNome()
        );
    }
}