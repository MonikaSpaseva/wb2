package wb2.whatsmissing_subtestNo7;

public class QuestionAndAnswerTestNo7 {
    private String question;
    private boolean isCorrect;

    public QuestionAndAnswerTestNo7 (String question, boolean isCorrect){
        this.question = question;
        this.isCorrect = isCorrect;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void toggle() {
        this.isCorrect = !isCorrect;
    }
}
