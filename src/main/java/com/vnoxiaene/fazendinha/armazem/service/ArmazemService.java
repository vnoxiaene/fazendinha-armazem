package com.vnoxiaene.fazendinha.armazem.service;

import com.vnoxiaene.fazendinha.armazem.dto.ArmazemRequestDTO;
import com.vnoxiaene.fazendinha.armazem.dto.ArmazemResponseDTO;
import com.vnoxiaene.fazendinha.armazem.entity.Armazem;
import com.vnoxiaene.fazendinha.armazem.mapper.ArmazemMapper;
import com.vnoxiaene.fazendinha.armazem.repository.ArmazemRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArmazemService {

  private final ArmazemRepository armazemRepository;

  public ArmazemResponseDTO save(ArmazemRequestDTO requestDTO) {
    Armazem armazem = ArmazemMapper.INSTANCE.dtoToEntity(requestDTO);
    armazem.setUuid(UUID.randomUUID());
    return ArmazemMapper.INSTANCE.entityToDTO(armazemRepository.save(armazem));
  }
}
