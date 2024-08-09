package org.desafio.service;

import org.desafio.entidades.Peca;
import org.desafio.entidades.Posicao;
import org.desafio.entidades.TabuleiroDeXadrez;
import org.desafio.enumeradores.CorEnum;
import org.desafio.util.ConversorDePosicao;

public class XadrezService {


    public static void realizarJogada(String posicaoInicial, String posicaoFinal, int vezNumero) {
        var tabuleiroDeXadrez = TabuleiroDeXadrez.getTabuleiro();
        var linhaInicial = ConversorDePosicao.converterLinhaDeXadrezParaMatriz(String.valueOf(posicaoInicial.charAt(1)));
        var colunaInicial = ConversorDePosicao.converterColunaDeXadrezParaMatriz(String.valueOf(posicaoInicial.charAt(0)));
        var linhaFinal = ConversorDePosicao.converterLinhaDeXadrezParaMatriz(String.valueOf(posicaoFinal.charAt(1)));
        var colunaFinal = ConversorDePosicao.converterColunaDeXadrezParaMatriz(String.valueOf(posicaoFinal.charAt(0)));
        var peca = tabuleiroDeXadrez[linhaInicial][colunaInicial];

        var xeque = verificarXeque(vezNumero, tabuleiroDeXadrez);


        if (peca == null) {
            throw new IllegalArgumentException("Nao existe peca nessa posicao");
            //verifica se nao estou tentando acessar uma peca que nao eh "minha"
        } else if (peca.getCor() != CorEnum.BRANCO && vezNumero % 2 == 0 || peca.getCor() == CorEnum.BRANCO && vezNumero % 2 == 1) {
            var corString = (vezNumero % 2 == 0) ? "branco" : "preto";
            throw new IllegalArgumentException("esta na vez do " + corString);
        }


        if (xeque && !peca.getName().equals('R')) {
            throw new IllegalArgumentException("Voce esta em xeque precisa mover o rei");
        }


        var jogadas = peca.movimentosPossiveis(tabuleiroDeXadrez, linhaInicial, colunaInicial);

        if (!jogadas[linhaFinal][colunaFinal]) {
            throw new IllegalArgumentException("Jogada invalida!");
        }

        var pecaCapturada = tabuleiroDeXadrez[linhaFinal][colunaFinal];
        tabuleiroDeXadrez[linhaInicial][colunaInicial] = null;
        tabuleiroDeXadrez[linhaFinal][colunaFinal] = peca;


        System.out.println("Movimento realizado de " + posicaoInicial + " para " + posicaoFinal);
        if (pecaCapturada != null) {
            System.out.println("Peca capturada: " + pecaCapturada.getClass().getSimpleName());
        }
    }


    public static boolean verificarXeque(int vezNumero, Peca[][] tabuleiroDeXadrez) {
        var corString = (vezNumero % 2 == 0) ? CorEnum.BRANCO : CorEnum.PRETO;

        Posicao posicaoDoRei = new Posicao();

        //verifica a posicaoDoRei do Rei

        outerLoop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiroDeXadrez[i][j] != null && tabuleiroDeXadrez[i][j].getName().equals('R') && tabuleiroDeXadrez[i][j].getCor().equals(corString)) {
                    posicaoDoRei.setLinha(i);
                    posicaoDoRei.setColuna(j);
                    break outerLoop;
                }
            }
        }

        //verifica se o rei esta em xeque
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiroDeXadrez[i][j] != null && tabuleiroDeXadrez[i][j].getCor() != corString) {
                    var movimentos = tabuleiroDeXadrez[i][j].movimentosPossiveis(tabuleiroDeXadrez, i, j);
                    if (movimentos[posicaoDoRei.getLinha()][posicaoDoRei.getColuna()]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



}
