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

        return movimentosPossiveis;
    }

    private boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < 8 && coluna >= 0 && coluna < 8;
    }
}
