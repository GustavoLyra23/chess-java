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

        //subir diagonalmente pra direita
        for (int j = coluna; j < 7; j++) {
            if (linhaCopy == 0) {
                break;
            }
            if (tabuleiro[linhaCopy - 1][j + 1] == null) {
                movientosPossiveis[linhaCopy - 1][j + 1] = true;
                linhaCopy--;
            } else if (tabuleiro[linhaCopy - 1][j + 1].getCor() != tabuleiro[linha][coluna].getCor()) {
                movientosPossiveis[linhaCopy - 1][j + 1] = true;
                break;
            } else {
                break;
            }
        }


        var colunaCopy = coluna;
        //descer diagonalmente para direita
        for (int i = linha; i < 7; i++) {
            if (colunaCopy == 7) {
                break;
            }
            if (tabuleiro[i + 1][colunaCopy + 1] == null) {
                movientosPossiveis[i + 1][colunaCopy + 1] = true;
                colunaCopy++;
            } else if (tabuleiro[i + 1][colunaCopy + 1].getCor() != tabuleiro[linha][coluna].getCor()) {
                movientosPossiveis[i + 1][colunaCopy + 1] = true;
                break;
            } else {
                break;
            }
        }

        linhaCopy = linha;
        //subir diagonalmente para esquerda
        for (int j = coluna; j > 0; j--) {
            if (linhaCopy == 0) {
                break;
            }
            if (tabuleiro[linhaCopy - 1][j - 1] == null) {
                movientosPossiveis[linhaCopy - 1][j - 1] = true;
                linhaCopy--;
            } else if (tabuleiro[linhaCopy - 1][j - 1].getCor() != tabuleiro[linha][coluna].getCor()) {
                movientosPossiveis[linhaCopy - 1][j - 1] = true;
                break;
            } else {
                break;
            }
        }

        linhaCopy = linha;
        //descer diagonalmente para esquerda
        for (int i = coluna; i > 0; i--) {
            if (linhaCopy == 7) {
                break;
            }
            if (tabuleiro[linhaCopy + 1][i - 1] == null) {
                movientosPossiveis[linhaCopy + 1][i - 1] = true;
                linhaCopy++;
            } else if (tabuleiro[linhaCopy + 1][i - 1].getCor() != tabuleiro[linha][coluna].getCor()) {
                movientosPossiveis[linhaCopy + 1][i - 1] = true;
                break;
            } else {
                break;
            }
        }


        return movientosPossiveis;
    }
}
