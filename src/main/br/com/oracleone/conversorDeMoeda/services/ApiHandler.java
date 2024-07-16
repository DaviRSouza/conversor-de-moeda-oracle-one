package main.br.com.oracleone.conversorDeMoeda.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.br.com.oracleone.conversorDeMoeda.models.CurrencyRate;

public class ApiHandler {
    public static CurrencyRate getRate(String currencyCode, String targetCurrencyCode, double amount) {
        String resultJson = ApiRequest.fetchData(currencyCode, targetCurrencyCode, amount);
        CurrencyRateDeserializer deserializer = new CurrencyRateDeserializer(currencyCode, targetCurrencyCode, amount);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(CurrencyRate.class, deserializer)
                .create();

        return gson.fromJson(resultJson, CurrencyRate.class);
    }
}