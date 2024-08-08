package org.desafio.entidades.pecas;

import org.desafio.entidades.Peca;
import org.desafio.enumeradores.CorEnum;

public class Torre extends Peca {

    public Torre(CorEnum cor) {
        super(cor, 'T');
    }

    @Override
    public boolean[][] movimentosPossiveis(Peca[][] tabuleiro, int linha, int coluna) {
        boolean[][] movimentos = new boolean[8][8];

        // vertical para cima
        for (int i = linha - 1; i >= 0; i--) {
            if (tabuleiro[i][coluna] == null) {
                movimentos[i][coluna] = true;
            } else {
                if (tabuleiro[i][coluna].getCor() != this.cor) {
                    movimentos[i][coluna] = true;
                }
                break;
            }
        }

        //  vertical para baixo
        for (int i = linha + 1; i < 8; i++) {
            if (tabuleiro[i][coluna] == null) {
                movimentos[i][coluna] = true;
            } else {
                if (tabuleiro[i][coluna].getCor() != this.cor) {
                    movimentos[i][coluna] = true;
                }
                break;
            }
        }

        // horizontal para a esquerda
        for (int i = coluna - 1; i >= 0; i--) {
            if (tabuleiro[linha][i] == null) {
                movimentos[linha][i] = true;
            } else {
                if (tabuleiro[linha][i].getCor() != this.cor) {
                    movimentos[linha][i] = true;
                }
                break;
            }
        }

        // horizontal para a direita
        for (int i = coluna + 1; i < 8; i++) {
            if (tabuleiro[linha][i] == null) {
                movimentos[linha][i] = true;
            } else {
                if (tabuleiro[linha][i].getCor() != this.cor) {
                    movimentos[linha][i] = true;
                }
                break;
            }
        }

        return movimentos;
    }

}

