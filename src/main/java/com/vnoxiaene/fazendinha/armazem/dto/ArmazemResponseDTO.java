package com.vnoxiaene.fazendinha.armazem.dto;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set", toBuilder = true)
@Getter
public class ArmazemResponseDTO {

  private final String uuid;
  private final String item;
  private final String galinhaUuid;
  private final BigInteger quantidade;
  private final String dataCadastro;
  private final String criadoEm;
}
