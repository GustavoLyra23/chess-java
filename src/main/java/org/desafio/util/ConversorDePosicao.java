package org.desafio.util;

public class ConversorDePosicao {

    public static Integer converterColunaDeXadrezParaMatriz(String colunaXadrez) {
        return switch (colunaXadrez.toLowerCase()) {
            case "a" -> 0;
            case "b" -> 1;
            case "c" -> 2;
            case "d" -> 3;
            case "e" -> 4;
            case "f" -> 5;
            case "g" -> 6;
            case "h" -> 7;
            default -> throw new IllegalArgumentException("PosicaoDoRei Invalida!");
        };
    }

    public static Integer converterLinhaDeXadrezParaMatriz(String linhaXadrez) {
        return switch (linhaXadrez.toLowerCase()) {
            case "8" -> 0;
            case "7" -> 1;
            case "6" -> 2;
            case "5" -> 3;
            case "4" -> 4;
            case "3" -> 5;
            case "2" -> 6;
            case "1" -> 7;
            default -> throw new IllegalArgumentException("PosicaoDoRei Invalida!");
        };
    }

    public static String converterColunaDeMatrizParaXadrez(int colunaXadrez) {
        return switch (colunaXadrez) {
            case 0 -> "a";
            case 1 -> "b";
            case 2 -> "c";
            case 3 -> "d";
            case 4 -> "e";
            case 5 -> "f";
            case 6 -> "g";
            case 7 -> "h";
            default -> throw new IllegalArgumentException("PosicaoDoRei Invalida!");
        };
    }

    public static String converterLinhaDeMatrizParaXadrez(int linhaXadrez) {
        return switch (linhaXadrez) {
            case 0 -> "8";
            case 1 -> "7";
            case 2 -> "6";
            case 3 -> "5";
            case 4 -> "4";
            case 5 -> "3";
            case 6 -> "2";
            case 7 -> "1";
            default -> throw new IllegalArgumentException("PosicaoDoRei Invalida!");
        };

    }
}
