package org.desafio.entidades;

import org.desafio.enumeradores.CorEnum;

public abstract class Peca {

    protected CorEnum cor;
    protected Character name;

    protected Peca(CorEnum cor, Character name) {
        this.cor = cor;
        this.name = name;
    }

    public CorEnum getCor() {
        return cor;
    }

    public Character getName() {
        return name;
    }

    public abstract boolean[][] movimentosPossiveis(Peca[][] tabuleiro, int linha, int coluna);


    @Override
    public String toString() {
        return name.toString();
    }
}
