package com.frotaapi.service;

import com.frotaapi.dto.AbastecimentoRequestDTO;
import com.frotaapi.dto.AbastecimentoResponseDTO;
import com.frotaapi.exception.ResourceNotFoundException;
import com.frotaapi.mapper.AbastecimentoMapper;
import com.frotaapi.model.Abastecimento;
import com.frotaapi.repository.AbastecimentoRepository;
import com.frotaapi.repository.VeiculoRepository;
import com.frotaapi.model.Veiculo;
import com.frotaapi.repository.MotoristaRepository;
import com.frotaapi.model.Motorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository repository;

    @Autowired
    private AbastecimentoMapper mapper;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Transactional(readOnly = true)
    public List<AbastecimentoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AbastecimentoResponseDTO buscar(Long id) {
        Abastecimento entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Abastecimento não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AbastecimentoResponseDTO criar(AbastecimentoRequestDTO dto) {
        Abastecimento entity = mapper.toEntity(dto);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Motorista motorista = motoristaRepository.findById(dto.getMotoristaId())
            .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com id: " + dto.getMotoristaId()));
        entity.setMotorista(motorista);
        Abastecimento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AbastecimentoResponseDTO atualizar(Long id, AbastecimentoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Abastecimento não encontrado com id: " + id);
        }
        Abastecimento entity = mapper.toEntity(dto);
        entity.setId(id);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Motorista motorista = motoristaRepository.findById(dto.getMotoristaId())
            .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com id: " + dto.getMotoristaId()));
        entity.setMotorista(motorista);
        Abastecimento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Abastecimento não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
