package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}
