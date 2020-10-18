package wb2.calculations_subtestNo4;

import java.util.LinkedList;
import java.util.List;

public class ManageSubtestNo4 {
    private List<QuestionAndAnswerSubtestNo4> listQuestionsAndAnswers;

    public ManageSubtestNo4() {
        this.listQuestionsAndAnswers = new LinkedList<>();
    }

    public void addAnswer(QuestionAndAnswerSubtestNo4 qAndA4) {
        listQuestionsAndAnswers.add(qAndA4);
    }

    public QuestionAndAnswerSubtestNo4 findByIndex(int index) {
        if (index > listQuestionsAndAnswers.size() || index < 0) {
            return null;
        }
        return listQuestionsAndAnswers.get(index - 1);
    }

    public void clear() {
        listQuestionsAndAnswers = new LinkedList<>();
    }

    public void printPoints() {
        int sum = 0;

        for (QuestionAndAnswerSubtestNo4 l : listQuestionsAndAnswers) {
            if (l.isTwoPoints()) {
                sum += 2;
            } else if (l.isOnePoint()) {
                sum += 1;
            }
            if (l.isPlusTwo()) {
                sum += 2;
            } else if (l.isPlusOne()) {
                sum += 1;
            }

        }
        System.out.println();
        System.out.println("Сметање (поени) = " + sum + ("/27"));
    }

    public int getPoints() {
        int sum = 0;

        for (QuestionAndAnswerSubtestNo4 l : listQuestionsAndAnswers) {
            if (l.isTwoPoints()) {
                sum += 2;
            } else if (l.isOnePoint()) {
                sum += 1;
            }
            if (l.isPlusTwo()) {
                sum += 2;
            } else if (l.isPlusOne()) {
                sum += 1;
            }

        }
        return sum;
    }

    public void printListOfAnswers() {
        System.out.println();
        System.out.println("Листа со поени: ");
        System.out.println();
        for (QuestionAndAnswerSubtestNo4 current : listQuestionsAndAnswers) {
            int posA = current.getMathProblem().indexOf("?");
            String until = current.getMathProblem().substring(0, posA);
            if (current.isTwoPoints() && current.isPlusTwo()) {
                System.out.println(until + " -> 4 поени");
            } else if (current.isTwoPoints() && current.isPlusOne()) {
                System.out.println(until + " -> 3 поени");
            } else if (current.isTwoPoints()) {
                System.out.println(until + " -> 2 поени");
            } else if (current.isOnePoint()) {
                System.out.println(until + " -> 1 поен");
            } else {
                System.out.println(until + " -> 0 поени");
            }
        }
    }


}
