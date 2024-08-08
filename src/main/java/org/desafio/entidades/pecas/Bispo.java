package org.desafio.entidades.pecas;

import org.desafio.entidades.Peca;
import org.desafio.enumeradores.CorEnum;

public class Bispo extends Peca {
    public Bispo(CorEnum cor) {
        super(cor, 'B');
    }

    @Override
    public boolean[][] movimentosPossiveis(Peca[][] tabuleiro, int linha, int coluna) {
        boolean[][] movientosPossiveis = new boolean[8][8];
        var linhaCopy = linha;

        //subir verticalmente
        for (int j = coluna; j < 7; j++) {
            if (linhaCopy == 0) {
                break;
            }
            if (tabuleiro[linhaCopy - 1][j + 1] == null) {
                movientosPossiveis[linhaCopy - 1][j + 1] = true;
                linhaCopy--;
            } else {
                break;
            }
        }


        return movientosPossiveis;
    }
}
