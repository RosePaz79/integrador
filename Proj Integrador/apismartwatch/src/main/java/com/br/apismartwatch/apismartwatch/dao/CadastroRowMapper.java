package com.br.apismartwatch.apismartwatch.dao;

import com.br.apismartwatch.apismartwatch.model.Cadastro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroRowMapper implements RowMapper<Cadastro> {

    @Override
    public Cadastro mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Cadastro cadastro = new Cadastro();
        cadastro.setId(resultSet.getInt("id"));
        cadastro.setNome(resultSet.getString("nome"));
        cadastro.setEmail(resultSet.getString("email"));
        cadastro.setPassword(resultSet.getString("password"));
        return cadastro;
    }
}


