package com.br.apismartwatch.apismartwatch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Paciente {

    @Id
    private Integer id;

    private String nome;

    private int codigoreferencia;

    private String pressao;

    private Byte batimentos;

    private String temperatura;

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public Byte getBatimentos() {
        return batimentos;
    }

    public void setBatimentos(Byte batimentos) {
        this.batimentos = batimentos;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoreferencia() {
        return codigoreferencia;
    }

    public void setCodigoreferencia(int codigoreferencia) {
        this.codigoreferencia = codigoreferencia;
    }

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }
}
