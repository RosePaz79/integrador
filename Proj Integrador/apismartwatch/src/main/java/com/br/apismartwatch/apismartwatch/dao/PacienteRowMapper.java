package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Paciente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteRowMapper implements RowMapper<Paciente> {

    @Override
    public Paciente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setId(resultSet.getInt("id"));
        paciente.setNome(resultSet.getString("nome"));
        paciente.setBatimentos(resultSet.getByte("batimentos"));
        paciente.setTemperatura(resultSet.getString("temperatura"));
        paciente.setPressao(resultSet.getString("pressao"));
        paciente.setCodigoreferencia(resultSet.getByte("codigoreferencia"));
        return paciente;
    }
}


