package util;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Api;

public class ApiUtil {
    public String requisicaoFrase() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.api-ninjas.com/v2/randomquotes?category=success"))
                    .header("X-Api-Key", "Qz5FhUL70dsvaZ8yVPiHhduVIhs7MNpH2eDeC3My")
                    .build();
            HttpResponse<String> response = client
                    .send(request, BodyHandlers.ofString());
            Gson gson = new Gson();

            Type tiposervice = new TypeToken<List<Api>>() {
            }.getType();
            List<Api> service = gson.fromJson(response.body(), tiposervice);

            String citacao = service.stream().map(elemento -> elemento.getCitacao()).findFirst().toString();
            return citacao;

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    record TranslationData(String text, String detected_source_language) {
    }

    record TranslationResponse(List<TranslationData> translations) {
    }

    public String traduzir() {
        try {

            String json = """
                    {
                      "text": ["%s"],
                      "target_lang": "PT"
                    }
                    """.formatted(requisicaoFrase());

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-free.deepl.com/v2/translate"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "DeepL-Auth-Key bf9db09c-e108-4eb0-8817-992a077f4181:fx")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
            HttpResponse<String> response = client
                    .send(request, BodyHandlers.ofString());
            Gson gson = new Gson();

            TranslationResponse resposta = gson.fromJson(response.body(), TranslationResponse.class);

            if (resposta != null && resposta.translations() != null && !resposta.translations().isEmpty()) {

                
                String textoTraduzido = resposta.translations().get(0).text();
                int inicio = textoTraduzido.indexOf("[") + 1;
                int fim = textoTraduzido.indexOf("]");
                String resultado = textoTraduzido.substring(inicio, fim);
                return resultado;

            } else {
                String erro = "Resposta vazia ou inválida da API. Status: " + response.statusCode();
                return erro;
            }

            
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
