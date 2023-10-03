package com.vnoxiaene.fazendinha.armazem.service;

import static org.mockito.ArgumentMatchers.any;

import com.vnoxiaene.fazendinha.armazem.dto.ArmazemRequestDTO;
import com.vnoxiaene.fazendinha.armazem.dto.ArmazemResponseDTO;
import com.vnoxiaene.fazendinha.armazem.entity.Armazem;
import com.vnoxiaene.fazendinha.armazem.enums.ITEM;
import com.vnoxiaene.fazendinha.armazem.repository.ArmazemRepository;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArmazemServiceTest {

  @Mock
  ArmazemRepository armazemRepository;

  @InjectMocks
  ArmazemService armazemService;

  @Test
  void shouldReturnCorrectDTOWhenSaveRequest() {
    //given
    UUID uuid = UUID.fromString("dab4fcc9-0819-4662-8ebe-3c85c7858f61");
    MockedStatic<UUID> uuidMockedStatic = Mockito.mockStatic(UUID.class,
        InvocationOnMock::callRealMethod);
    uuidMockedStatic.when(UUID::randomUUID).thenReturn(uuid);
    ArmazemRequestDTO.ArmazemRequestDTOBuilder armazemRequestDTOBuilder = ArmazemRequestDTO.builder();
    armazemRequestDTOBuilder.setItem("OVO");
    armazemRequestDTOBuilder.setQuantidade(BigInteger.TEN);
    armazemRequestDTOBuilder.setDataCadastro("2023-09-10");
    armazemRequestDTOBuilder.setGalinhaUuid("ce9f3971-0b27-4503-b3d7-8751cea61a20");
    ArmazemRequestDTO armazemRequestDTO = armazemRequestDTOBuilder.build();
    ArmazemResponseDTO responseDTO = ArmazemResponseDTO.builder()
        .setItem("OVO")
        .setGalinhaUuid("ce9f3971-0b27-4503-b3d7-8751cea61a20")
        .setQuantidade(BigInteger.TEN)
        .setUuid(uuid.toString())
        .setDataCadastro("2023-09-10").build();
    Armazem armazem = Armazem.builder().setItem(ITEM.OVO)
        .setUuid(uuid)
        .setDataCadastro(LocalDate.parse("2023-09-10"))
        .setQuantidade(BigInteger.TEN)
        .setGalinhaUuid(UUID.fromString("ce9f3971-0b27-4503-b3d7-8751cea61a20"))
        .setId(1L)
        .setCriadoEm(LocalDate.now()).build();
    Mockito.when(armazemRepository.save(any())).thenReturn(armazem);
    //when
    ArmazemResponseDTO save = armazemService.save(armazemRequestDTO);
    //then
    Assertions.assertThat(save.getItem()).isEqualTo(responseDTO.getItem());
    Assertions.assertThat(save.getUuid()).isEqualTo(responseDTO.getUuid());
    Assertions.assertThat(save.getQuantidade()).isEqualTo(responseDTO.getQuantidade());
  }
}