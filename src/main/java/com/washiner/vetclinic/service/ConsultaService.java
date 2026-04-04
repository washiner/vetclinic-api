package com.washiner.vetclinic.service;

import com.washiner.vetclinic.domain.entity.Animal;
import com.washiner.vetclinic.domain.entity.Consulta;
import com.washiner.vetclinic.domain.entity.Veterinario;
import com.washiner.vetclinic.dto.request.ConsultaRequest;
import com.washiner.vetclinic.dto.response.ConsultaResponse;
import com.washiner.vetclinic.exception.EntidadeNaoEncontradaException;
import com.washiner.vetclinic.repository.AnimalRepository;
import com.washiner.vetclinic.repository.ConsultaRepository;
import com.washiner.vetclinic.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final AnimalRepository animalRepository;
    private final VeterinarioRepository veterinarioRepository;

    @Transactional(readOnly = true)
    public Page<ConsultaResponse> listarTodos(Pageable pageable) {
        return consultaRepository.findAll(pageable)
                .map(ConsultaResponse::from);
    }

    @Transactional(readOnly = true)
    public ConsultaResponse buscarPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Consulta não encontrada com id: " + id));
        return ConsultaResponse.from(consulta);
    }

    @Transactional
    public ConsultaResponse criar(ConsultaRequest request) {
        Animal animal = animalRepository.findById(request.animalId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Animal não encontrado com id: " + request.animalId()));

        Veterinario veterinario = veterinarioRepository.findById(request.veterinarioId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veterinário não encontrado com id: " + request.veterinarioId()));

        Consulta consulta = new Consulta();
        consulta.setDataHora(request.dataHora());
        consulta.setMotivo(request.motivo());
        consulta.setDiagnostico(request.diagnostico());
        consulta.setStatus(request.status());
        consulta.setAnimal(animal);
        consulta.setVeterinario(veterinario);

        return ConsultaResponse.from(consultaRepository.save(consulta));
    }

    @Transactional
    public ConsultaResponse atualizar(Long id, ConsultaRequest request) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Consulta não encontrada com id: " + id));

        Animal animal = animalRepository.findById(request.animalId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Animal não encontrado com id: " + request.animalId()));

        Veterinario veterinario = veterinarioRepository.findById(request.veterinarioId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veterinário não encontrado com id: " + request.veterinarioId()));

        consulta.setDataHora(request.dataHora());
        consulta.setMotivo(request.motivo());
        consulta.setDiagnostico(request.diagnostico());
        consulta.setStatus(request.status());
        consulta.setAnimal(animal);
        consulta.setVeterinario(veterinario);

        return ConsultaResponse.from(consultaRepository.save(consulta));
    }

    @Transactional
    public void deletar(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Consulta não encontrada com id: " + id));
        consultaRepository.delete(consulta);
    }
}