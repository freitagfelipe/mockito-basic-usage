package api.mock;

import java.io.IOException;
import java.util.ArrayList;

import api.mock.API.DatamuseAPI;
import api.mock.Controller.GetSpelledSimilarlyWordsController;

public class App {
    public static void main(String[] args) {
        GetSpelledSimilarlyWordsController controller = new GetSpelledSimilarlyWordsController(new DatamuseAPI());

        try {
            ArrayList<String> results = controller.get("apple");

            for (String result : results) {
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
