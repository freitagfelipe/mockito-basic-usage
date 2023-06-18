package api.mock.Controller;

import java.io.IOException;
import java.util.ArrayList;

import api.mock.API.Interface.API;
import api.mock.Model.Response;

public class GetSpelledSimilarlyWordsController {
    private API api;

    public GetSpelledSimilarlyWordsController(API api) {
        this.api = api;
    }

    public ArrayList<String> get(String word) throws IOException, InterruptedException {
        Response[] result = this.api.getSpelledSimilarlyWords(word);

        if (result == null) {
            return new ArrayList<>();
        }

        ArrayList<String> words = new ArrayList<>();

        for (Response response : result) {
            words.add(response.getWord());
        }

        return words;
    }
}
