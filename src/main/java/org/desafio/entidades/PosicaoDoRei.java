package org.desafio.entidades;

import org.desafio.entidades.pecas.Rei;

public class PosicaoDoRei {

    private Integer linha;
    private Integer coluna;
    private Rei rei;

    public PosicaoDoRei() {
    }


    public PosicaoDoRei(Integer linha, Integer coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }

    public Rei getRei() {
        return rei;
    }

    public void setRei(Rei rei) {
        this.rei = rei;
    }
}
