package api.mock.Controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import api.mock.API.Interface.API;
import api.mock.Model.Response;

public class GetSpelledSimilarlyWordsControllerTest {
    @Test
    public void unsuccessfulRequestShouldReturnEmptyArrayList() throws Exception {
        API api = mock(API.class);
        String word = "hipopatamus";

        when(api.getSpelledSimilarlyWords(word)).thenReturn(null);

        GetSpelledSimilarlyWordsController controller = new GetSpelledSimilarlyWordsController(api);

        ArrayList<String> result = controller.get(word);

        assertEquals(0, result.size());

        verify(api, times(1)).getSpelledSimilarlyWords(word);
    }

    @Test
    public void successfulRequestShouldReturnAnArrayListOfWords() throws Exception {
        API api = mock(API.class);
        String word = "hipopatamus";
        Response[] response = {
            new Response("hippopotamus", 501),
            new Response("hippotamus", 1)
        };

        when(api.getSpelledSimilarlyWords(word)).thenReturn(response);

        GetSpelledSimilarlyWordsController controller = new GetSpelledSimilarlyWordsController(api);

        ArrayList<String> result = controller.get(word);

        assertEquals(result, new ArrayList<>(Arrays.asList("hippopotamus", "hippotamus")));

        verify(api, times(1)).getSpelledSimilarlyWords(word);
    }
}
