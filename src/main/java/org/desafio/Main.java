package org.desafio;

import java.util.Scanner;

import org.desafio.entidades.TabuleiroDeXadrez;
import org.desafio.exception.XequeMateException;
import org.desafio.service.XadrezService;
import org.desafio.ui.UI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TabuleiroDeXadrez.inicializarTabuleiro();
        int i = 0;

        while (true) {
            try {
                UI.carregaTabuleiroDeXadrez(TabuleiroDeXadrez.getTabuleiro());
                var xeque = XadrezService.verificarXequeMate(i, TabuleiroDeXadrez.getTabuleiro());
                if(xeque){
                 throw new XequeMateException("Xeque Mate");
                }
                
                var jogadaIncial = UI.perguntarJogadaInicial(sc, i);
                var jogadaFinal = UI.perguntarJogadaFinal(sc);
                XadrezService.realizarJogada(jogadaIncial, jogadaFinal, i);
                i++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (XequeMateException e) {
                System.out.println(e.getMessage());
                break;
            } catch(StringIndexOutOfBoundsException exception){
               System.out.println("Jogada invalida");
            }
        }

    }
}