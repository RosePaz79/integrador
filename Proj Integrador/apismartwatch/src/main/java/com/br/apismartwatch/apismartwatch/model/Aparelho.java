package com.br.apismartwatch.apismartwatch.model;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class Aparelho {

    @jakarta.persistence.Id
    @Id
    private int id;

    private String descricao;

    private boolean ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
