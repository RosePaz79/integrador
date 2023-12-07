package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Aparelho;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AparelhoRowMapper implements RowMapper<Aparelho> {

    @Override
    public Aparelho mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Aparelho aparelho = new Aparelho();
        aparelho.setId(resultSet.getInt("id"));
        aparelho.setDescricao(resultSet.getString("descricao"));
        aparelho.setAtivo(resultSet.getBoolean("ativo"));
        return aparelho;
    }
}


