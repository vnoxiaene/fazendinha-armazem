package com.vnoxiaene.fazendinha.armazem.mapper;

import com.vnoxiaene.fazendinha.armazem.dto.ArmazemRequestDTO;
import com.vnoxiaene.fazendinha.armazem.dto.ArmazemResponseDTO;
import com.vnoxiaene.fazendinha.armazem.entity.Armazem;
import java.time.LocalDate;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArmazemMapper {

  ArmazemMapper INSTANCE = Mappers.getMapper(ArmazemMapper.class);


  @Mapping(target = "dataCadastro", source = "requestDTO", qualifiedByName = "dataCadastro")
  @Mapping(target = "galinhaUuid", source = "requestDTO", qualifiedByName = "galinhaUuid")
  Armazem dtoToEntity(ArmazemRequestDTO requestDTO);

  @Mapping(target = "dataCadastro", source = "armazem", qualifiedByName = "dataCadastroToString")
  @Mapping(target = "galinhaUuid", source = "armazem", qualifiedByName = "galinhaUuidToString")
  @Mapping(target = "uuid", source = "armazem", qualifiedByName = "uuidToString")
  ArmazemResponseDTO entityToDTO(Armazem armazem);

  @Named("dataCadastro")
  default LocalDate mapDataCadastro(ArmazemRequestDTO dto) {
    return LocalDate.parse(dto.getDataCadastro());
  }

  @Named("dataCadastroToString")
  default String mapDataCadastroToString(Armazem armazem) {
    return armazem.getDataCadastro().toString();
  }

  @Named("galinhaUuid")
  default UUID mapGalinhaUuid(ArmazemRequestDTO dto) {
    return UUID.fromString(dto.getGalinhaUuid());
  }

  @Named("galinhaUuidToString")
  default String mapGalinhaUuid(Armazem armazem) {
    return armazem.getGalinhaUuid().toString();
  }

  @Named("uuidToString")
  default String mapUuidToString(Armazem armazem) {
    return armazem.getUuid().toString();
  }
}
