package api.mock.API.Interface;

import java.io.IOException;

import api.mock.Model.Response;

public interface API {
    public Response[] getSpelledSimilarlyWords(String word) throws IOException, InterruptedException;
}
