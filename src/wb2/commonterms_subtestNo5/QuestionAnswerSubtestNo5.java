package wb2.commonterms_subtestNo5;

public class QuestionAnswerSubtestNo5 {
    private String questionAndAnswer;
    private boolean isCorrectTwoPoints;
    private boolean isCorrectOnePoint;

    public QuestionAnswerSubtestNo5(String questionAndAnswer, boolean isCorrectTwoPoints, boolean isCorrectOnePoint) {
        this.questionAndAnswer = questionAndAnswer;
        this.isCorrectTwoPoints = isCorrectTwoPoints;
        this.isCorrectOnePoint = isCorrectOnePoint;
    }

    public String getQuestionAndAnswer() {
        return questionAndAnswer;
    }

    public boolean isCorrectOnePoint() {
        return isCorrectOnePoint;
    }

    public boolean isCorrectTwoPoints() {
        return isCorrectTwoPoints;
    }

    public void onePoint() {
        this.isCorrectOnePoint = true;
        this.isCorrectTwoPoints = false;
    }

    public void twoPoints() {
        this.isCorrectTwoPoints = true;
        this.isCorrectOnePoint = false;
    }
    public void zeroPoints() {
        this.isCorrectOnePoint = false;
        this.isCorrectTwoPoints = false;
    }

}
