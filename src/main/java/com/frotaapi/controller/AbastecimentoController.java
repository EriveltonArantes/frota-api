package com.frotaapi.controller;

import com.frotaapi.dto.AbastecimentoRequestDTO;
import com.frotaapi.dto.AbastecimentoResponseDTO;
import com.frotaapi.service.AbastecimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Abastecimento", description = "Gerenciamento de abastecimentos")
@RestController
@RequestMapping("/api/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService service;

    @Operation(summary = "Listar todos os Abastecimento")
    @GetMapping
    public List<AbastecimentoResponseDTO> listar(@RequestParam(required = false) String posto, @RequestParam(required = false) Long veiculoId, @RequestParam(required = false) Long motoristaId) {
        List<AbastecimentoResponseDTO> resultado = service.listar();
        if (posto != null && !posto.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getPosto() != null &&
                item.getPosto().toLowerCase().contains(posto.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (veiculoId != null) {
            resultado = resultado.stream().filter(item -> veiculoId.equals(item.getVeiculoId())).collect(java.util.stream.Collectors.toList());
        }
        if (motoristaId != null) {
            resultado = resultado.stream().filter(item -> motoristaId.equals(item.getMotoristaId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Abastecimento por ID")
    @GetMapping("/{id}")
    public AbastecimentoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Abastecimento")
    @PostMapping
    public ResponseEntity<AbastecimentoResponseDTO> criar(@Valid @RequestBody AbastecimentoRequestDTO abastecimento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(abastecimento));
    }

    @Operation(summary = "Atualizar Abastecimento")
    @PutMapping("/{id}")
    public AbastecimentoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody AbastecimentoRequestDTO abastecimento) {
        return service.atualizar(id, abastecimento);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Abastecimento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
