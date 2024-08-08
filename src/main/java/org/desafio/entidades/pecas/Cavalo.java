package org.desafio.entidades.pecas;

import org.desafio.entidades.Peca;
import org.desafio.enumeradores.CorEnum;

public class Cavalo extends Peca {
    public Cavalo(CorEnum cor) {
        super(cor,'C');
    }

    @Override
    public boolean[][] movimentosPossiveis(Peca[][] tabuleiro, int linha, int coluna) {
        // Implementação dos movimentos possíveis do Cavalo
        boolean[][] movimentos = new boolean[8][8];
        // lógica dos movimentos
        return movimentos;
    }
}