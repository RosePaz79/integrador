package com.br.apismartwatch.apismartwatch.service;

import com.br.apismartwatch.apismartwatch.dao.AparelhoDao;
import com.br.apismartwatch.apismartwatch.model.Aparelho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AparelhoServiceImpl implements AparelhoService {

    @Autowired
    private AparelhoDao aparelhoDao;

    @Override
    public List<Aparelho> getAllAparelho() {
        return aparelhoDao.getAllAparelho();
    }
}