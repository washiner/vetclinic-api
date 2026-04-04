package com.washiner.vetclinic.controller;

import com.washiner.vetclinic.dto.request.TutorRequest;
import com.washiner.vetclinic.dto.response.TutorResponse;
import com.washiner.vetclinic.service.TutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @GetMapping
    public ResponseEntity<Page<TutorResponse>> listarTodos(
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(tutorService.listarTodos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tutorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TutorResponse> criar(@RequestBody @Valid TutorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tutorService.criar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorResponse> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid TutorRequest request) {
        return ResponseEntity.ok(tutorService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}