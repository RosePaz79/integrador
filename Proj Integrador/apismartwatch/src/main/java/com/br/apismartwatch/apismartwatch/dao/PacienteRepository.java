package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
