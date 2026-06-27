package com.frotaapi.service;

import com.frotaapi.dto.ManutencaoRequestDTO;
import com.frotaapi.dto.ManutencaoResponseDTO;
import com.frotaapi.exception.ResourceNotFoundException;
import com.frotaapi.mapper.ManutencaoMapper;
import com.frotaapi.model.Manutencao;
import com.frotaapi.repository.ManutencaoRepository;
import com.frotaapi.repository.VeiculoRepository;
import com.frotaapi.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository repository;

    @Autowired
    private ManutencaoMapper mapper;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional(readOnly = true)
    public List<ManutencaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ManutencaoResponseDTO buscar(Long id) {
        Manutencao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Manutencao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ManutencaoResponseDTO criar(ManutencaoRequestDTO dto) {
        Manutencao entity = mapper.toEntity(dto);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Manutencao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ManutencaoResponseDTO atualizar(Long id, ManutencaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Manutencao não encontrado com id: " + id);
        }
        Manutencao entity = mapper.toEntity(dto);
        entity.setId(id);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Manutencao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Manutencao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
