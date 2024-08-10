package org.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.desafio.entidades.Peca;
import org.desafio.entidades.PosicaoDoRei;
import org.desafio.entidades.TabuleiroDeXadrez;
import org.desafio.entidades.pecas.Rei;
import org.desafio.enumeradores.CorEnum;
import org.desafio.exception.XequeMateException;
import org.desafio.util.ConversorDePosicao;

public class XadrezService {

    private static PosicaoDoRei posicaoDoRei = new PosicaoDoRei(); 
    private static List<Peca> pecasQueSalvamORei = new ArrayList<>();


    public static void realizarJogada(String posicaoInicial, String posicaoFinal, int vezNumero) {
        var tabuleiroDeXadrez = TabuleiroDeXadrez.getTabuleiro();
        var linhaInicial = ConversorDePosicao.converterLinhaDeXadrezParaMatriz(String.valueOf(posicaoInicial.charAt(1)));
        var colunaInicial = ConversorDePosicao.converterColunaDeXadrezParaMatriz(String.valueOf(posicaoInicial.charAt(0)));
        var linhaFinal = ConversorDePosicao.converterLinhaDeXadrezParaMatriz(String.valueOf(posicaoFinal.charAt(1)));
        var colunaFinal = ConversorDePosicao.converterColunaDeXadrezParaMatriz(String.valueOf(posicaoFinal.charAt(0)));
        var peca = tabuleiroDeXadrez[linhaInicial][colunaInicial];

        var xeque  = verificarXeque(vezNumero, tabuleiroDeXadrez);
        if(xeque){
           System.out.println("Xeque!");
        }

         var xequeMate = verificarXequeMate(vezNumero, tabuleiroDeXadrez);
        if (xequeMate) {
            throw new XequeMateException("Xeque-mate");
        }
        if (peca == null) {
            throw new IllegalArgumentException("Nao existe peca nessa posicao");
            //verifica se nao estou tentando acessar uma peca que nao eh "minha"
        } else if (peca.getCor() != CorEnum.BRANCO && vezNumero % 2 == 0 || peca.getCor() == CorEnum.BRANCO && vezNumero % 2 == 1) {
            var corString = (vezNumero % 2 == 0) ? "branco" : "preto";
            throw new IllegalArgumentException("esta na vez do " + corString);
        }

        var jogadas = peca.movimentosPossiveis(tabuleiroDeXadrez, linhaInicial, colunaInicial);

        if (!jogadas[linhaFinal][colunaFinal]) {
            throw new IllegalArgumentException("Jogada invalida!");
        }

        var pecaCapturada = tabuleiroDeXadrez[linhaFinal][colunaFinal];
        tabuleiroDeXadrez[linhaInicial][colunaInicial] = null;
        tabuleiroDeXadrez[linhaFinal][colunaFinal] = peca;
        
        if(verificarXequeMate(vezNumero, tabuleiroDeXadrez)){
            throw new XequeMateException("Xeque Mate");
         }



        if(verificarXeque(vezNumero, tabuleiroDeXadrez)){
            tabuleiroDeXadrez[linhaFinal][colunaFinal] = null;
            tabuleiroDeXadrez[linhaInicial][colunaInicial] = peca;
            throw new IllegalArgumentException("Xeque ainda existe");                          
         }     

        System.out.println("Movimento realizado de " + posicaoInicial + " para " + posicaoFinal);
        if (pecaCapturada != null) {
            System.out.println("Peca capturada: " + pecaCapturada.getClass().getSimpleName());
        }
    }

    public static boolean verificarXeque(int vezNumero, Peca[][] tabuleiroDeXadrez) {
        var corString = (vezNumero % 2 == 0) ? CorEnum.BRANCO : CorEnum.PRETO;

        //verifica a posicaoDoRei do Rei
        outerLoop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiroDeXadrez[i][j] != null && tabuleiroDeXadrez[i][j].getName().equals('R') && tabuleiroDeXadrez[i][j].getCor().equals(corString)) {
                    posicaoDoRei.setLinha(i);
                    posicaoDoRei.setColuna(j);
                    posicaoDoRei.setRei((Rei) tabuleiroDeXadrez[i][j]);
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

    private static boolean verificarSeOReiPodeSerMover(Rei rei, Peca[][] tabuleiroDeXadrez) {
        var movimentos = rei.movimentosPossiveis(tabuleiroDeXadrez, posicaoDoRei.getLinha(), posicaoDoRei.getColuna());
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (movimentos[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verificarXequeMate(int vezNumero, Peca[][] tabuleiroDeXadrez) {
        return verificarXeque(vezNumero, tabuleiroDeXadrez) && !verificarSeOReiPodeSerMover(posicaoDoRei.getRei(), tabuleiroDeXadrez) && !verificarPecasQueSalvam(vezNumero, tabuleiroDeXadrez);
    }

    public static boolean verificarPecasQueSalvam(int vezNumero, Peca[][] tabuleiroDeXadrez) {
       pecasQueSalvamORei.clear();
       
        var corString = (vezNumero % 2 == 0) ? CorEnum.BRANCO : CorEnum.PRETO;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiroDeXadrez[i][j] != null && tabuleiroDeXadrez[i][j].getCor().equals(corString)) {
                    var movimentos = tabuleiroDeXadrez[i][j].movimentosPossiveis(tabuleiroDeXadrez, i, j);
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (movimentos[k][l] == true) {
                                var peca = tabuleiroDeXadrez[i][j];
                                tabuleiroDeXadrez[i][j] = null;
                                tabuleiroDeXadrez[k][l] = peca;
                               if(!verificarXeque(vezNumero, tabuleiroDeXadrez)){
                                pecasQueSalvamORei.add(peca);
                                tabuleiroDeXadrez[k][l] = null;
                                tabuleiroDeXadrez[i][j] = peca;
                                //voltar as pecas para as posicoes originais
                               } else {
                                tabuleiroDeXadrez[k][l] = null;
                                tabuleiroDeXadrez[i][j] = peca;
                                //voltar as pecas para as posicoes originais
                               }
                            }
                        }
                    }

                }

            }

        }
       
        if (!pecasQueSalvamORei.isEmpty()) {
            return true;
        }
       
        return false;
    }

}
