package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Aparelho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AparelhoRepository extends JpaRepository<Aparelho, Long> {
}
