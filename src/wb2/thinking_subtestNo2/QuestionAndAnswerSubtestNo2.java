package wb2.thinking_subtestNo2;

public class QuestionAndAnswerSubtestNo2 {
    private String question;
    private boolean isAnswerTwoPoints;
    private boolean isIsAnswerOnePoint;

    public QuestionAndAnswerSubtestNo2(String question, boolean isAnswerTwoPoints, boolean isAnswerOnePoint) {
        this.question = question;
        this.isAnswerTwoPoints = isAnswerTwoPoints;
        this.isIsAnswerOnePoint = isAnswerOnePoint;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isAnswerTwoPoints() {
        return isAnswerTwoPoints;
    }

    public boolean isIsAnswerOnePoint() {
        return isIsAnswerOnePoint;
    }

    public void onePoint() {
        this.isIsAnswerOnePoint = true;
        this.isAnswerTwoPoints = false;
    }

    public void twoPoints() {
        this.isAnswerTwoPoints = true;
        this.isIsAnswerOnePoint = false;
    }
    public void zeroPoints() {
        this.isIsAnswerOnePoint = false;
        this.isAnswerTwoPoints = false;
    }
}
