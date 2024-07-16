package main.br.com.oracleone.conversorDeMoeda.services;

import com.google.gson.*;
import main.br.com.oracleone.conversorDeMoeda.models.CurrencyRate;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class CurrencyRateDeserializer implements JsonDeserializer<CurrencyRate> {

    private String baseCoin;
    private String targetCoin;
    private Double amount;
    LocalDateTime requestDate;

    public CurrencyRateDeserializer(String baseCoin, String targetCoin, Double amount) {
        this.baseCoin = baseCoin;
        this.targetCoin = targetCoin;
        this.amount = amount;
        requestDate = LocalDateTime.now();
    }

    @Override
    public CurrencyRate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        double convertedAmount = jsonObject.get("conversion_result").getAsDouble();

        return new CurrencyRate(baseCoin, targetCoin, amount, convertedAmount, requestDate);
    }
}
