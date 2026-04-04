package com.washiner.vetclinic.dto.response;

import com.washiner.vetclinic.domain.entity.Veterinario;

public record VeterinarioResponse(
        Long id,
        String nome,
        String crmv,
        String email,
        String telefone
) {
    public static VeterinarioResponse from(Veterinario veterinario) {
        return new VeterinarioResponse(
                veterinario.getId(),
                veterinario.getNome(),
                veterinario.getCrmv(),
                veterinario.getEmail(),
                veterinario.getTelefone()
        );
    }
}