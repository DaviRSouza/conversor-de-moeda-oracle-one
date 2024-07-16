package main.br.com.oracleone.conversorDeMoeda.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record CurrencyRate(String baseCoin, String targetCoin, Double amount, Double convertedAmount,
                           LocalDateTime requestDate) {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Override
    public String toString() {
        return String.format("Conversão de %s para %s: %.2f %s = %.2f %s em %s",
                baseCoin, targetCoin, amount, baseCoin, convertedAmount, targetCoin, requestDate.format(formatter));
    }

}
