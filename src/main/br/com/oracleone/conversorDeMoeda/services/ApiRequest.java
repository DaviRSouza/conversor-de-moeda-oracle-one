package main.br.com.oracleone.conversorDeMoeda.services;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ApiRequest {
    public static String fetchData(String currencyCode, String targetCurrencyCode, double amount) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            String apiKey = System.getenv("EXCHANGERATE_API_KEY");
            String parameters = apiKey + "/pair/"
                    + URLEncoder.encode(currencyCode, StandardCharsets.UTF_8) + "/"
                    + URLEncoder.encode(targetCurrencyCode, StandardCharsets.UTF_8) + "/"
                    + URLEncoder.encode(String.valueOf(amount), StandardCharsets.UTF_8);

            URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + parameters);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar a requisição para a API");
        }
    }
}
