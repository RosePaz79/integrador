package com.br.apismartwatch.apismartwatch.service;

import com.br.apismartwatch.apismartwatch.dao.CadastroDao;
import com.br.apismartwatch.apismartwatch.model.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroServiceImpl implements CadastroService {

    @Autowired
    private CadastroDao cadastroDao;

    @Override
    public List<Cadastro> getAllCadastros() {
        return cadastroDao.getAllCadastros();
    }
}