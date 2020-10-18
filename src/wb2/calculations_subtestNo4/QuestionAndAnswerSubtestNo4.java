package wb2.calculations_subtestNo4;

public class QuestionAndAnswerSubtestNo4 {
    private final String mathProblem;
    private boolean isOnePoint;
    private boolean isTwoPoints;
    private boolean plusOne;
    private boolean plusTwo;


    public QuestionAndAnswerSubtestNo4(String mathProblem, boolean isOnePoint, boolean isTwoPoints, boolean plusOne, boolean plusTwo) {
        this.mathProblem = mathProblem;
        this.isOnePoint = isOnePoint;
        this.isTwoPoints = isTwoPoints;
        this.plusOne = plusOne;
        this.plusTwo = plusTwo;
    }

    public String getMathProblem() {
        return mathProblem;
    }

    public boolean isOnePoint() {
        return isOnePoint;
    }


    public boolean isTwoPoints() {
        return isTwoPoints;
    }

    public boolean isPlusOne() {
        return plusOne;
    }

    public boolean isPlusTwo() {
        return plusTwo;
    }

    public void onePoint() {
        this.isOnePoint = true;
        this.isTwoPoints = false;
        this.plusOne = false;
        this.plusTwo = false;
    }

    public void twoPoints() {
        this.isTwoPoints = true;
        this.isOnePoint = false;
        this.plusOne = false;
        this.plusTwo = false;
    }

    public void zeroPoints() {
        this.isOnePoint = false;
        this.isTwoPoints = false;
        this.plusOne = false;
        this.plusTwo = false;
    }

    public void threePoints() {
        this.isTwoPoints = true;
        this.plusOne = true;
        this.isOnePoint = false;
        this.plusTwo = false;
    }

    public void fourPoints() {
        this.isTwoPoints = true;
        this.plusOne = false;
        this.isOnePoint = false;
        this.plusTwo = true;
    }
}
