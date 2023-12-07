package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Aparelho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AparelhoDaoImpl implements AparelhoDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final ConsultaProvider consultaProvider;

    @Autowired
    public AparelhoDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ConsultaProvider consultaProvider) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.consultaProvider = consultaProvider;
    }

    @Override
    public List<Aparelho> getAllAparelho() {
        String consultaSql = consultaProvider.obterConsultaAparelho();
        return namedParameterJdbcTemplate.query(consultaSql, new AparelhoRowMapper());
    }
}
