package com.br.apismartwatch.apismartwatch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaProvider {

    private final ConsultaLoader consultaLoader;

    @Autowired
    public ConsultaProvider(ConsultaLoader consultaLoader) {
        this.consultaLoader = consultaLoader;
    }
    public String obterConsultaCadastro() {
        return consultaLoader.carregarConsultaPorId("cadastro");
    }

    public String obterConsultaPaciente() {
        return consultaLoader.carregarConsultaPorId("paciente");
    }

    public String obterConsultaAparelho() {
        return consultaLoader.carregarConsultaPorId("aparelho");
    }
}
