package org.desafio.entidades.pecas;

import org.desafio.entidades.Peca;
import org.desafio.enumeradores.CorEnum;

public class Rainha extends Peca {

    public Rainha(CorEnum cor) {
        super(cor, 'Q');
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

        // vertical para cima
        for (int i = linha - 1; i >= 0; i--) {
            if (tabuleiro[i][coluna] == null) {
                movientosPossiveis[i][coluna] = true;
            } else {
                if (tabuleiro[i][coluna].getCor() != this.cor) {
                    movientosPossiveis[i][coluna] = true;
                }
                break;
            }
        }

        //  vertical para baixo
        for (int i = linha + 1; i < 8; i++) {
            if (tabuleiro[i][coluna] == null) {
                movientosPossiveis[i][coluna] = true;
            } else {
                if (tabuleiro[i][coluna].getCor() != this.cor) {
                    movientosPossiveis[i][coluna] = true;
                }
                break;
            }
        }

        // horizontal para a esquerda
        for (int i = coluna - 1; i >= 0; i--) {
            if (tabuleiro[linha][i] == null) {
                movientosPossiveis[linha][i] = true;
            } else {
                if (tabuleiro[linha][i].getCor() != this.cor) {
                    movientosPossiveis[linha][i] = true;
                }
                break;
            }
        }

        // horizontal para a direita
        for (int i = coluna + 1; i < 8; i++) {
            if (tabuleiro[linha][i] == null) {
                movientosPossiveis[linha][i] = true;
            } else {
                if (tabuleiro[linha][i].getCor() != this.cor) {
                    movientosPossiveis[linha][i] = true;
                }
                break;
            }
        }

        int[] linhas = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colunas = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < linhas.length; i++) {
            int novaLinha = linha + linhas[i];
            int novaColuna = coluna + colunas[i];
            if (posicaoValida(novaLinha, novaColuna) && (tabuleiro[novaLinha][novaColuna] == null || tabuleiro[novaLinha][novaColuna].getCor() != this.cor)) {
                movientosPossiveis[novaLinha][novaColuna] = true;
            }
        }

        return movientosPossiveis;
    }

    private boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < 8 && coluna >= 0 && coluna < 8;
    }

}
