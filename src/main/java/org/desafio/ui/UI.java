package org.desafio.ui;

import org.desafio.entidades.Peca;
import org.desafio.enumeradores.CorEnum;
import org.desafio.util.ConversorDePosicao;

import java.util.Scanner;

public class UI {

    public static final String BLACK = "\033[0;30m";
    public static final String WHITE = "\033[0;37m";   // Branco
    public static final String RESET = "\033[0m";
    public static String color;


    public static void carregaTabuleiroDeXadrez(Peca[][] tabuleiroDeXadrez) {
        for (int i = 0; i < tabuleiroDeXadrez.length; i++) {
            var linha = ConversorDePosicao.converterLinhaDeMatrizParaXadrez(i);
            System.out.print(linha + " ");

            for (int j = 0; j < tabuleiroDeXadrez[i].length; j++) {
                if (tabuleiroDeXadrez[i][j] == null) {
                    System.out.print(". ");
                } else {
                    color = (tabuleiroDeXadrez[i][j].getCor().equals(CorEnum.BRANCO)) ? WHITE : BLACK;
                    System.out.print(color + tabuleiroDeXadrez[i][j] + " " + RESET);
                }
            }
            System.out.println();
        }

        System.out.print("  ");
        for (int j = 0; j < tabuleiroDeXadrez[0].length; j++) {
            var coluna = ConversorDePosicao.converterColunaDeMatrizParaXadrez(j);
            System.out.print(coluna + " ");
        }
        System.out.println();
    }

    public static String perguntarJogadaInicial(Scanner sc, int numeroVez) {
        verificarVez(numeroVez);
        System.out.println("posicao inicial: ");
        return sc.next();
    }

    public static String perguntarJogadaFinal(Scanner sc) {
        System.out.println("posicao final: ");
        return sc.next();
    }


    private static void verificarVez(int numeroVez) {
        if (numeroVez % 2 == 0) {
            System.out.println("Vez do Branco");
        } else {
            System.out.println("Vez do Preto");
        }
    }
}


