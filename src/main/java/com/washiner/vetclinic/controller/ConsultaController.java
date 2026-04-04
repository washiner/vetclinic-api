package com.washiner.vetclinic.controller;

import com.washiner.vetclinic.dto.request.ConsultaRequest;
import com.washiner.vetclinic.dto.response.ConsultaResponse;
import com.washiner.vetclinic.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<Page<ConsultaResponse>> listarTodos(
            @PageableDefault(size = 10, sort = "dataHora") Pageable pageable) {
        return ResponseEntity.ok(consultaService.listarTodos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ConsultaResponse> criar(@RequestBody @Valid ConsultaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.criar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ConsultaRequest request) {
        return ResponseEntity.ok(consultaService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        consultaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}