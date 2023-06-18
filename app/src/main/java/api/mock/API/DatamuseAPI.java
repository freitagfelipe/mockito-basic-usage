package api.mock.API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import api.mock.API.Interface.API;
import api.mock.Model.Response;

public class DatamuseAPI implements API {
    private static String API_URL = "https://api.datamuse.com/words?sp=";

    @Override
    public Response[] getSpelledSimilarlyWords(String word) {
        StringBuilder sb = new StringBuilder();

        sb.append(DatamuseAPI.API_URL).append(word);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(sb.toString()))
            .build();

        HttpResponse<String> response;

        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            return null;
        } catch (InterruptedException e) {
            return null;
        }

        if (response.statusCode() != 200) {
            return null;
        }

        Gson gson = new Gson();

        Response[] data = gson.fromJson(response.body(), Response[].class);

        return data;
    }
    
}
