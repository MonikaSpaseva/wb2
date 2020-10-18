package wb2.thinking_subtestNo2;

import java.util.LinkedList;
import java.util.List;

public class ManageSubtestNo2 {
    private List<QuestionAndAnswerSubtestNo2> list;

    public ManageSubtestNo2() {
        this.list = new LinkedList<>();
    }

    public void addAnswer(QuestionAndAnswerSubtestNo2 questionAndAnswer) {
        list.add(questionAndAnswer);
    }

    public QuestionAndAnswerSubtestNo2 findIndex(int index) {
        if (index > list.size() || index < 0) {
            return null;
        }
        return list.get(index - 1);
    }


    public void clear() {
        list = new LinkedList<>();
    }

    public void printListOfAnswers() {
        System.out.println();
        System.out.println("Листа со поени: ");
        System.out.println();
        for (QuestionAndAnswerSubtestNo2 current : list) {
            int posA = current.getQuestion().indexOf("?");
            String until = current.getQuestion().substring(0, posA);
            if (current.isAnswerTwoPoints()) {
                System.out.println(until + " - 2 поени");
            } else if (current.isIsAnswerOnePoint()) {
                System.out.println(until + " - 1 поен");
            } else {
                System.out.println(until + " - 0 поени");
            }
        }
    }

    public void printPoints() {
        int sum = 0;
        for (QuestionAndAnswerSubtestNo2 l : list) {
            if (l.isAnswerTwoPoints()) {
                sum += 2;
            } else if (l.isIsAnswerOnePoint()) {
                sum += 1;
            }
        }
        System.out.println();
        System.out.println("Сфаќање (поени) = " + sum + ("/20"));
    }

    public int getPoints() {
        int sum = 0;
        for (QuestionAndAnswerSubtestNo2 l : list) {
            if (l.isAnswerTwoPoints()) {
                sum += 2;
            } else if (l.isIsAnswerOnePoint()) {
                sum += 1;
            }
        }
        return sum;
    }
}
