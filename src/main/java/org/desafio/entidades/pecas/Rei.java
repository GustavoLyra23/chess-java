package org.desafio.entidades.pecas;

import org.desafio.entidades.Peca;
import org.desafio.enumeradores.CorEnum;

public class Rei extends Peca {
    public Rei(CorEnum cor) {
        super(cor, 'R');
    }

    @Override
    public boolean[][] movimentosPossiveis(Peca[][] tabuleiro, int linha, int coluna) {
        boolean[][] movimentosPossiveis = new boolean[8][8];

        int[] linhas = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colunas = {-1, 0, 1, -1, 1, -1, 0, 1};


        for (int i = 0; i < linhas.length; i++) {
            int novaLinha = linha + linhas[i];
            int novaColuna = coluna + colunas[i];

            if (posicaoValida(novaLinha, novaColuna) && (tabuleiro[novaLinha][novaColuna] == null || tabuleiro[novaLinha][novaColuna].getCor() != this.cor)) {
                movimentosPossiveis[novaLinha][novaColuna] = true;
            }
        }

        boolean[][] ameacasAdversarias = new boolean[8][8];
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] != null && tabuleiro[i][j].getCor() != this.cor) {
                    if (tabuleiro[i][j] instanceof Rei) {
                        continue;
                    }

                    var movimentos = tabuleiro[i][j].movimentosPossiveis(tabuleiro, i, j);

                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (movimentos[k][l]) {
                                ameacasAdversarias[k][l] = true;
                            }
                        }
                    }
                }
            }
        }


        for (int i = 0; i < linhas.length; i++) {
            int novaLinha = linha + linhas[i];
            int novaColuna = coluna + colunas[i];

            if (posicaoValida(novaLinha, novaColuna) && tabuleiro[novaLinha][novaColuna] instanceof Rei && tabuleiro[novaLinha][novaColuna].getCor() != this.cor) {
                ameacasAdversarias[novaLinha][novaColuna] = true;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ameacasAdversarias[i][j]) {
                    movimentosPossiveis[i][j] = false;
                }
            }
        }

        return movimentosPossiveis;
    }

    private boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < 8 && coluna >= 0 && coluna < 8;
    }
}