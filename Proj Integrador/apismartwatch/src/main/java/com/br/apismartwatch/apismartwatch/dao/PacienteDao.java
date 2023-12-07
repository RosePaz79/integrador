package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Paciente;

import java.util.List;

public interface PacienteDao {
    List<Paciente> getAllPaciente();
    Paciente getPacienteById(Long id);
    Paciente createPaciente(Paciente paciente);
    void updatePaciente(Paciente paciente);
    void deletePaciente(Long id);
}
