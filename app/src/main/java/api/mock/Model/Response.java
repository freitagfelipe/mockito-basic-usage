package api.mock.Model;

public class Response {
    private String word;
    private int score;

    public Response(String word, int score) {
        this.word = word;
        this.score = score;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
