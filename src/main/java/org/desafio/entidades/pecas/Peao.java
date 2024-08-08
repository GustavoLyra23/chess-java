package org.desafio.entidades.pecas;

import org.desafio.entidades.Peca;
import org.desafio.enumeradores.CorEnum;

public class Peao extends Peca {

    public Peao(CorEnum cor) {
        super(cor, 'P');
    }

    @Override
    public boolean[][] movimentosPossiveis(Peca[][] tabuleiro, int linha, int coluna) {
        boolean[][] movimentosPossiveis = new boolean[8][8];

        if (cor == CorEnum.BRANCO) {

            if (linha > 0 && tabuleiro[linha - 1][coluna] == null) {
                movimentosPossiveis[linha - 1][coluna] = true;
            }

            if (linha == 6 && tabuleiro[linha - 1][coluna] == null && tabuleiro[linha - 2][coluna] == null) {
                movimentosPossiveis[linha - 2][coluna] = true;
            }

            if (linha > 0 && coluna > 0 && tabuleiro[linha - 1][coluna - 1] != null && tabuleiro[linha - 1][coluna - 1].getCor() != this.cor) {
                movimentosPossiveis[linha - 1][coluna - 1] = true;
            }

            if (linha > 0 && coluna < 7 && tabuleiro[linha - 1][coluna + 1] != null && tabuleiro[linha - 1][coluna + 1].getCor() != this.cor) {
                movimentosPossiveis[linha - 1][coluna + 1] = true;
            }
        } else {

            if (linha < 7 && tabuleiro[linha + 1][coluna] == null) {
                movimentosPossiveis[linha + 1][coluna] = true;
            }

            if (linha == 1 && tabuleiro[linha + 1][coluna] == null && tabuleiro[linha + 2][coluna] == null) {
                movimentosPossiveis[linha + 2][coluna] = true;
            }

            if (linha < 7 && coluna > 0 && tabuleiro[linha + 1][coluna - 1] != null && tabuleiro[linha + 1][coluna - 1].getCor() != this.cor) {
                movimentosPossiveis[linha + 1][coluna - 1] = true;
            }

            if (linha < 7 && coluna < 7 && tabuleiro[linha + 1][coluna + 1] != null && tabuleiro[linha + 1][coluna + 1].getCor() != this.cor) {
                movimentosPossiveis[linha + 1][coluna + 1] = true;
            }
        }

        return movimentosPossiveis;
    }
}
