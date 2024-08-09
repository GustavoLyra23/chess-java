package org.desafio;

import org.desafio.entidades.TabuleiroDeXadrez;
import org.desafio.service.XadrezService;
import org.desafio.ui.UI;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TabuleiroDeXadrez.inicializarTabuleiro();
        int i = 0;

        while (1 < 2) {
            try {
                UI.carregaTabuleiroDeXadrez(TabuleiroDeXadrez.getTabuleiro());
                var jogadaIncial = UI.perguntarJogadaInicial(sc, i);
                var jogadaFinal = UI.perguntarJogadaFinal(sc);
                XadrezService.realizarJogada(jogadaIncial, jogadaFinal, i);
                i++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}