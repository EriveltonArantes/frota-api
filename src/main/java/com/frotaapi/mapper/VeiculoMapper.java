package com.frotaapi.mapper;

import com.frotaapi.dto.VeiculoRequestDTO;
import com.frotaapi.dto.VeiculoResponseDTO;
import com.frotaapi.model.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    Veiculo toEntity(VeiculoRequestDTO dto);

    VeiculoResponseDTO toResponseDTO(Veiculo entity);
}
