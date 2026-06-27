package com.frotaapi.mapper;

import com.frotaapi.dto.MotoristaRequestDTO;
import com.frotaapi.dto.MotoristaResponseDTO;
import com.frotaapi.model.Motorista;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MotoristaMapper {

    Motorista toEntity(MotoristaRequestDTO dto);

    MotoristaResponseDTO toResponseDTO(Motorista entity);
}
