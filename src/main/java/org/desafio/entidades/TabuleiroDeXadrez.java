package org.desafio.entidades;

import org.desafio.entidades.pecas.*;
import org.desafio.enumeradores.CorEnum;

public class TabuleiroDeXadrez {

    private static Peca[][] tabuleiro = new Peca[8][8];

    public static Peca[][] getTabuleiro() {
        return tabuleiro;
    }

    public static void inicializarTabuleiro() {
        // Peças Pretas
        tabuleiro[0][0] = new Torre(CorEnum.PRETO);
        tabuleiro[0][1] = new Cavalo(CorEnum.PRETO);
        tabuleiro[0][2] = new Bispo(CorEnum.PRETO);
        tabuleiro[0][3] = new Rainha(CorEnum.PRETO);
        tabuleiro[0][4] = new Rei(CorEnum.PRETO);
        tabuleiro[0][5] = new Bispo(CorEnum.PRETO);
        tabuleiro[0][6] = new Cavalo(CorEnum.PRETO);
        tabuleiro[0][7] = new Torre(CorEnum.PRETO);
        for (int i = 0; i < 8; i++) {
            tabuleiro[1][i] = new Peao(CorEnum.PRETO);
        }
        // Peças Brancas
        tabuleiro[7][0] = new Torre(CorEnum.BRANCO);
        tabuleiro[7][1] = new Cavalo(CorEnum.BRANCO);
        tabuleiro[7][2] = new Bispo(CorEnum.BRANCO);
        tabuleiro[7][3] = new Rainha(CorEnum.BRANCO);
        tabuleiro[7][4] = new Rei(CorEnum.BRANCO);
        tabuleiro[7][5] = new Bispo(CorEnum.BRANCO);
        tabuleiro[7][6] = new Cavalo(CorEnum.BRANCO);
        tabuleiro[7][7] = new Torre(CorEnum.BRANCO);
        for (int i = 0; i < 8; i++) {
            tabuleiro[6][i] = new Peao(CorEnum.BRANCO);
        }

    }
}
