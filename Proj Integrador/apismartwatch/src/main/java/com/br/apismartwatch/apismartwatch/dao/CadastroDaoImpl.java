package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CadastroDaoImpl implements CadastroDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final ConsultaProvider consultaProvider;

    @Autowired
    public CadastroDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ConsultaProvider consultaProvider) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.consultaProvider = consultaProvider;
    }

    @Override
    public List<Cadastro> getAllCadastros() {
        String consultaSql = consultaProvider.obterConsultaCadastro();
        return namedParameterJdbcTemplate.query(consultaSql, new CadastroRowMapper());
    }
}
