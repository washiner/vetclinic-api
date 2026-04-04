package com.washiner.vetclinic.service;

import com.washiner.vetclinic.domain.entity.Veterinario;
import com.washiner.vetclinic.dto.request.VeterinarioRequest;
import com.washiner.vetclinic.dto.response.VeterinarioResponse;
import com.washiner.vetclinic.exception.EntidadeNaoEncontradaException;
import com.washiner.vetclinic.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    @Transactional(readOnly = true)
    public Page<VeterinarioResponse> listarTodos(Pageable pageable) {
        return veterinarioRepository.findAll(pageable)
                .map(VeterinarioResponse::from);
    }

    @Transactional(readOnly = true)
    public VeterinarioResponse buscarPorId(Long id) {
        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veterinário não encontrado com id: " + id));
        return VeterinarioResponse.from(veterinario);
    }

    @Transactional
    public VeterinarioResponse criar(VeterinarioRequest request) {
        Veterinario veterinario = new Veterinario();
        veterinario.setNome(request.nome());
        veterinario.setCrmv(request.crmv());
        veterinario.setEmail(request.email());
        veterinario.setTelefone(request.telefone());
        return VeterinarioResponse.from(veterinarioRepository.save(veterinario));
    }

    @Transactional
    public VeterinarioResponse atualizar(Long id, VeterinarioRequest request) {
        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veterinário não encontrado com id: " + id));
        veterinario.setNome(request.nome());
        veterinario.setCrmv(request.crmv());
        veterinario.setEmail(request.email());
        veterinario.setTelefone(request.telefone());
        return VeterinarioResponse.from(veterinarioRepository.save(veterinario));
    }

    @Transactional
    public void deletar(Long id) {
        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veterinário não encontrado com id: " + id));
        veterinarioRepository.delete(veterinario);
    }
}