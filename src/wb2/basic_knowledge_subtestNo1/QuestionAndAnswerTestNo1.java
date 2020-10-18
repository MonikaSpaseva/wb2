package wb2.basic_knowledge_subtestNo1;

public class QuestionAndAnswerTestNo1 {
    private final String question;
    private boolean isCorrect;

    public QuestionAndAnswerTestNo1(String question, boolean isCorrect) {
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
