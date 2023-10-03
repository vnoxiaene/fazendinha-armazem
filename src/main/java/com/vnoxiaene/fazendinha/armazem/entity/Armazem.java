package com.vnoxiaene.fazendinha.armazem.entity;


import com.vnoxiaene.fazendinha.armazem.enums.ITEM;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder(toBuilder = true, setterPrefix = "set")
@NoArgsConstructor
@AllArgsConstructor
public class Armazem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private UUID uuid;
  private ITEM item;
  @Column(name = "galinha_uuid")
  private UUID galinhaUuid;
  private BigInteger quantidade;
  private LocalDate dataCadastro;
  private LocalDate criadoEm = LocalDate.now();


}
