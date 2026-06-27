package com.frotaapi.mapper;

import com.frotaapi.dto.ManutencaoRequestDTO;
import com.frotaapi.dto.ManutencaoResponseDTO;
import com.frotaapi.model.Manutencao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManutencaoMapper {

    @Mapping(target = "veiculo", ignore = true)
    Manutencao toEntity(ManutencaoRequestDTO dto);

    @Mapping(target = "veiculoId", source = "veiculo.id")
    ManutencaoResponseDTO toResponseDTO(Manutencao entity);
}
