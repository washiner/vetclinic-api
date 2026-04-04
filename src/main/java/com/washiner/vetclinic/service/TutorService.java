package com.washiner.vetclinic.service;

import com.washiner.vetclinic.domain.entity.Tutor;
import com.washiner.vetclinic.dto.request.TutorRequest;
import com.washiner.vetclinic.dto.response.TutorResponse;
import com.washiner.vetclinic.exception.EntidadeNaoEncontradaException;
import com.washiner.vetclinic.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    @Transactional(readOnly = true)
    public Page<TutorResponse> listarTodos(Pageable pageable) {
        return tutorRepository.findAll(pageable)
                .map(TutorResponse::from);
    }

    @Transactional(readOnly = true)
    public TutorResponse buscarPorId(Long id) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado com id: " + id));
        return TutorResponse.from(tutor);
    }

    @Transactional
    public TutorResponse criar(TutorRequest request) {
        Tutor tutor = new Tutor();
        tutor.setNome(request.nome());
        tutor.setCpf(request.cpf());
        tutor.setTelefone(request.telefone());
        tutor.setEmail(request.email());
        return TutorResponse.from(tutorRepository.save(tutor));
    }

    @Transactional
    public TutorResponse atualizar(Long id, TutorRequest request) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado com id: " + id));
        tutor.setNome(request.nome());
        tutor.setCpf(request.cpf());
        tutor.setTelefone(request.telefone());
        tutor.setEmail(request.email());
        return TutorResponse.from(tutorRepository.save(tutor));
    }

    @Transactional
    public void deletar(Long id) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado com id: " + id));
        tutorRepository.delete(tutor);
    }
}