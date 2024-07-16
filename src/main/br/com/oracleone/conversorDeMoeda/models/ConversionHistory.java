package main.br.com.oracleone.conversorDeMoeda.models;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private List<CurrencyRate> history;

    public ConversionHistory() {
        this.history = new ArrayList<>();
    }

    public void addConversion(CurrencyRate conversion) {
        history.add(conversion);
    }

    public List<CurrencyRate> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public String toString() {
        if (history.isEmpty()) {
            return "O histórico de conversões está vazio.";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Historico de conversões:\n");
            for (CurrencyRate rate : history) {
                sb.append("""
                        -----------------------------------
                        Data: %s
                        Moeda de origem: %s
                        Moeda de destino: %s
                        %.2f %s = %.2f %s
                        -----------------------------------
                        """.formatted(rate.requestDate().format(formatter),
                        rate.baseCoin(),
                        rate.targetCoin(),
                        rate.amount(),
                        rate.baseCoin(),
                        rate.convertedAmount(),
                        rate.targetCoin()));
            }
            return sb.toString();
        }
    }
}
