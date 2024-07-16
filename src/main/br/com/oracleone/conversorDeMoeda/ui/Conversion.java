package main.br.com.oracleone.conversorDeMoeda.ui;

import main.br.com.oracleone.conversorDeMoeda.models.CurrencyRate;
import main.br.com.oracleone.conversorDeMoeda.services.ApiHandler;

import java.util.Scanner;

public class Conversion {
    public static CurrencyRate convertCurrency(Scanner sc) {
        System.out.println("""
                Selecione a moeda de origem:
                1 - Real
                2 - Dólar
                3 - Euro
                4 - Libra
                5 - Iene
                6 - Yuan
                7 - Dólar Australiano
                8 - Dólar Canadense
                9 - Franco Suíço
                10 - Peso Argentino
                """);
        System.out.print("Sua escolha: ");
        int i = sc.nextInt();

        String baseCoin = switch (i) {
            case 1 -> "BRL";
            case 2 -> "USD";
            case 3 -> "EUR";
            case 4 -> "GBP";
            case 5 -> "JPY";
            case 6 -> "CNY";
            case 7 -> "AUD";
            case 8 -> "CAD";
            case 9 -> "CHF";
            case 10 -> "ARS";
            default -> throw new IllegalArgumentException("Opção inválida.");
        };

        System.out.print("""
                Selecione a moeda de destino:
                1 - Real
                2 - Dólar
                3 - Euro
                4 - Libra
                5 - Iene
                6 - Yuan
                7 - Dólar Australiano
                8 - Dólar Canadense
                9 - Franco Suíço
                10 - Peso Argentino
                """);
        System.out.print("Sua escolha: ");
        i = sc.nextInt();

        String targetCoin = switch (i) {
            case 1 -> "BRL";
            case 2 -> "USD";
            case 3 -> "EUR";
            case 4 -> "GBP";
            case 5 -> "JPY";
            case 6 -> "CNY";
            case 7 -> "AUD";
            case 8 -> "CAD";
            case 9 -> "CHF";
            case 10 -> "ARS";
            default -> throw new IllegalArgumentException("Opção inválida.");
        };

        System.out.print("Digite o valor a ser convertido:");
        double amount = sc.nextDouble();

        return ApiHandler.getRate(baseCoin, targetCoin, amount);
    }
}
