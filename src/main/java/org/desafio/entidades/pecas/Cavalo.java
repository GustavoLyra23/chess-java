package org.desafio.entidades.pecas;

import org.desafio.entidades.Peca;
import org.desafio.enumeradores.CorEnum;

public class Cavalo extends Peca {

    public Cavalo(CorEnum cor) {
        super(cor, 'C');
    }

    @Override
    public boolean[][] movimentosPossiveis(Peca[][] tabuleiro, int linha, int coluna) {
        // Implementação dos movimentos possíveis do Cavalo
        boolean[][] movimentos = new boolean[8][8];
        // lógica dos movimentos

        //subir pela direita
        if (linha >= 1 && coluna + 2 < 8) {
            if (tabuleiro[linha - 1][coluna + 2] == null) {
                movimentos[linha - 1][coluna + 2] = true;
            } else if (!tabuleiro[linha - 1][coluna + 2].getCor().equals(tabuleiro[linha][coluna].getCor())) {
                movimentos[linha - 1][coluna + 2] = true;
            }

            if (linha - 2 >= 0 && coluna + 1 < 8) {
                if (tabuleiro[linha - 2][coluna + 1] == null) {
                    movimentos[linha - 2][coluna + 1] = true;
                } else if (!tabuleiro[linha - 2][coluna + 1].getCor().equals(tabuleiro[linha][coluna].getCor())) {
                    movimentos[linha - 2][coluna + 1] = true;
                }
            }
        }

        //subir pela esquerda 
        if (linha - 1 >= 0 && coluna - 2 >= 0) {
            if (tabuleiro[linha - 1][coluna - 2] == null) {
                movimentos[linha - 1][coluna - 2] = true;
            } else if (!tabuleiro[linha - 1][coluna - 2].getCor().equals(tabuleiro[linha][coluna].getCor())) {
                movimentos[linha - 1][coluna - 2] = true;
            }
        }

        if (linha - 2 >= 0 && coluna - 1 >= 0) {
            if (tabuleiro[linha - 2][coluna - 1] == null) {
                movimentos[linha - 2][coluna - 1] = true;
            } else if (!tabuleiro[linha - 2][coluna - 1].getCor().equals(tabuleiro[linha][coluna].getCor())) {
                movimentos[linha - 2][coluna - 1] = true;
            }
        }

        //descer para direita
        if (linha + 2 < 8 && coluna + 1 < 8) {
            if (tabuleiro[linha + 2][coluna + 1] == null) {
                movimentos[linha + 2][coluna + 1] = true;
            } else if (!tabuleiro[linha + 2][coluna + 1].getCor().equals(tabuleiro[linha][coluna].getCor())) {
                movimentos[linha + 2][coluna + 1] = true;
            }
        }

        if (linha + 1 < 8 && coluna + 2 < 8) {
            if (tabuleiro[linha + 1][coluna + 2] == null) {
                movimentos[linha + 1][coluna + 2] = true;
            } else if (!tabuleiro[linha + 1][coluna + 2].getCor().equals(tabuleiro[linha][coluna].getCor())) {
                movimentos[linha + 1][coluna + 2] = true;
            }
        }

        //descer para esquerda
        if (linha + 2 < 8 && coluna - 1 >= 0) {
            if (tabuleiro[linha + 2][coluna - 1] == null) {
                movimentos[linha + 2][coluna - 1] = true;
            } else if (!tabuleiro[linha + 2][coluna - 1].getCor().equals(tabuleiro[linha][coluna].getCor())) {
                movimentos[linha + 2][coluna - 1] = true;
            }
        }

        if (linha + 1 < 8 && coluna - 2 >= 0) {
            if (tabuleiro[linha + 1][coluna - 2] == null) {
                movimentos[linha + 1][coluna - 2] = true;
            } else if (!tabuleiro[linha + 1][coluna - 2].getCor().equals(tabuleiro[linha][coluna].getCor())) {
                movimentos[linha + 1][coluna - 2] = true;
            }
        }

        return movimentos;
    }
}
