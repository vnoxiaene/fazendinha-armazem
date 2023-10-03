package com.vnoxiaene.fazendinha.armazem.dto;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true, setterPrefix = "set")
@Getter
public class ArmazemRequestDTO {

  private final String item;
  private final String galinhaUuid;
  private final BigInteger quantidade;
  private final String dataCadastro;

}
