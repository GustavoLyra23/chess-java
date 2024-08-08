package org.desafio.entidades.pecas;

import org.desafio.entidades.Peca;
import org.desafio.enumeradores.CorEnum;

public class Rainha extends Peca {
    public Rainha(CorEnum cor) {
        super(cor, 'Q');
    }

    @Override
    public boolean[][] movimentosPossiveis(Peca[][] tabuleiro, int linha, int coluna) {
        return new boolean[0][];
    }
}
