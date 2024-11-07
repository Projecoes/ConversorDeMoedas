import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApi {

    public static void converterMoeda(Referencias referencias) {
        // Chave e URL da API
        String chaveApi = "156dbb70e7490c06c7c7cedd";
        String url = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/pair/"
                + referencias.converterDe() + "/" + referencias.converterPara()
                + "/" + referencias.quantia();

        // Configuração do Gson
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        try {
            // Enviar a requisição HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar status e processa a resposta
            if (response.statusCode() == 200) {
                Conversao conversao = gson.fromJson(response.body(), Conversao.class);
                System.out.println(conversao);
            } else {
                System.out.println("Erro na API: código de status " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar a conversão de moeda: " + e.getMessage());
        }
    }
}