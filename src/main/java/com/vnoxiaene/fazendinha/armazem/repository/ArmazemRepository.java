package com.vnoxiaene.fazendinha.armazem.repository;

import com.vnoxiaene.fazendinha.armazem.entity.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmazemRepository extends JpaRepository<Armazem, Long> {

}
