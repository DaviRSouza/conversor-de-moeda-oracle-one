package main.br.com.oracleone.conversorDeMoeda;

import main.br.com.oracleone.conversorDeMoeda.models.ConversionHistory;
import main.br.com.oracleone.conversorDeMoeda.models.CurrencyRate;
import main.br.com.oracleone.conversorDeMoeda.ui.Conversion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConversionHistory history = new ConversionHistory();

        int i = 0;
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        do {
            System.out.println("""
                    -----------------------------------
                    1 - Realizar conversão
                    2 - Ver histórico de conversões
                    3 - Sair
                    -----------------------------------
                    """);
            System.out.print("sua escolha: ");
            i = sc.nextInt();

            switch (i) {
                case 1:
                    CurrencyRate conversion = Conversion.convertCurrency(sc);
                    System.out.println(conversion);
                    System.out.println("\n\n pressione enter para continuar...\n\n");
                    sc.nextLine();
                    sc.nextLine();
                    history.addConversion(conversion);
                    break;
                case 2:
                    System.out.println(history);
                    System.out.println("\n\n pressione enter para continuar...\n\n");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("Obrigado por usar o Conversor de Moedas!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (i != 3);
    }
}
