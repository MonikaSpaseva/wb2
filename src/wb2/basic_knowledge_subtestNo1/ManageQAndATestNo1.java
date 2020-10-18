package wb2.basic_knowledge_subtestNo1;

import java.util.LinkedList;
import java.util.List;

public class ManageQAndATestNo1 {
    private List<QuestionAndAnswerTestNo1> listQuestAndAnsNo1;

    public ManageQAndATestNo1() {
        this.listQuestAndAnsNo1 = new LinkedList<>();
    }

    public void addAnswers(QuestionAndAnswerTestNo1 qANDa) {
        listQuestAndAnsNo1.add(qANDa);
    }

    public QuestionAndAnswerTestNo1 findQuestionByIndex(int indexNumber) {

        if (indexNumber > listQuestAndAnsNo1.size() || indexNumber < 0) {
            System.out.println("Прашањето не е најдено");
            return null;
        }
        return listQuestAndAnsNo1.get(indexNumber  - 1);
    }

    public void printListOfAnswers() {
        System.out.println("Листа со поени ");
        for (int i = 0; i < listQuestAndAnsNo1.size(); i++) {
            String poen;
            if (listQuestAndAnsNo1.get(i).isCorrect()) {
                poen = "1 поен";
                System.out.println(listQuestAndAnsNo1.get(i).getQuestion() + " --> " + poen);
            } else {
                poen = "0 поени";
                System.out.println(listQuestAndAnsNo1.get(i).getQuestion() + " --> " + poen);
            }
        }
    }


    public void printPointsForTestNo1() {
        int sum = 0;
        for (QuestionAndAnswerTestNo1 list : listQuestAndAnsNo1) {
            if (list.isCorrect()) {
                sum = sum + 1;
            }
        }
        System.out.println("1. Поученост (поени) = " + (sum + 3) + "/30");
    }

    public int pointsForTestNo1() {
        int sum = 0;
        for (QuestionAndAnswerTestNo1 list : listQuestAndAnsNo1) {
            if (list.isCorrect()) {
                sum = sum + 1;
            }
        }
        return (sum + 3);
    }

    public void clear() {
        listQuestAndAnsNo1 = new LinkedList<>();
    }
}
