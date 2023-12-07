package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteDaoImpl implements PacienteDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final ConsultaProvider consultaProvider;
    private final ConsultaLoader consultaLoader;

    @Autowired
    public PacienteDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ConsultaProvider consultaProvider, ConsultaLoader consultaLoader) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.consultaProvider = consultaProvider;
        this.consultaLoader = consultaLoader;
    }

    @Override
    public List<Paciente> getAllPaciente() {
        String consultaSql = consultaProvider.obterConsultaPaciente();
        return namedParameterJdbcTemplate.query(consultaSql, new PacienteRowMapper());
    }

    @Override
    public Paciente getPacienteById(Long id) {
        return null;
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        String insertSqlId = "inserePaciente";        String insertSql = consultaLoader.carregarConsultaPorId(insertSqlId);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nome", paciente.getNome());
        params.addValue("batimentos", paciente.getBatimentos());
        params.addValue("temperatura", paciente.getTemperatura());
        params.addValue("pressao", paciente.getPressao());
        params.addValue("codigoreferencia", paciente.getCodigoreferencia());

        namedParameterJdbcTemplate.update(insertSql, params);
        return paciente;
    }

    @Override
    public void updatePaciente(Paciente paciente) {

    }

    @Override
    public void deletePaciente(Long id) {

    }
}
