package com.washiner.vetclinic.dto.response;

import com.washiner.vetclinic.domain.entity.Tutor;

public record TutorResponse(
        Long id,
        String nome,
        String telefone,
        String email
) {
    public static TutorResponse from(Tutor tutor) {
        return new TutorResponse(
                tutor.getId(),
                tutor.getNome(),
                tutor.getTelefone(),
                tutor.getEmail()
        );
    }
}