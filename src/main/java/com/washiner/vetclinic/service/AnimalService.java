package com.washiner.vetclinic.service;

import com.washiner.vetclinic.domain.entity.Animal;
import com.washiner.vetclinic.domain.entity.Tutor;
import com.washiner.vetclinic.dto.request.AnimalRequest;
import com.washiner.vetclinic.dto.response.AnimalResponse;
import com.washiner.vetclinic.exception.EntidadeNaoEncontradaException;
import com.washiner.vetclinic.repository.AnimalRepository;
import com.washiner.vetclinic.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final TutorRepository tutorRepository;

    @Transactional(readOnly = true)
    public Page<AnimalResponse> listarTodos(Pageable pageable) {
        return animalRepository.findAll(pageable)
                .map(AnimalResponse::from);
    }

    @Transactional(readOnly = true)
    public AnimalResponse buscarPorId(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Animal não encontrado com id: " + id));
        return AnimalResponse.from(animal);
    }

    @Transactional
    public AnimalResponse criar(AnimalRequest request) {
        Tutor tutor = tutorRepository.findById(request.tutorId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado com id: " + request.tutorId()));

        Animal animal = new Animal();
        animal.setNome(request.nome());
        animal.setEspecie(request.especie());
        animal.setRaca(request.raca());
        animal.setDataNascimento(request.dataNascimento());
        animal.setSexo(request.sexo());
        animal.setTutor(tutor);

        return AnimalResponse.from(animalRepository.save(animal));
    }

    @Transactional
    public AnimalResponse atualizar(Long id, AnimalRequest request) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Animal não encontrado com id: " + id));

        Tutor tutor = tutorRepository.findById(request.tutorId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tutor não encontrado com id: " + request.tutorId()));

        animal.setNome(request.nome());
        animal.setEspecie(request.especie());
        animal.setRaca(request.raca());
        animal.setDataNascimento(request.dataNascimento());
        animal.setSexo(request.sexo());
        animal.setTutor(tutor);

        return AnimalResponse.from(animalRepository.save(animal));
    }

    @Transactional
    public void deletar(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Animal não encontrado com id: " + id));
        animalRepository.delete(animal);
    }
}