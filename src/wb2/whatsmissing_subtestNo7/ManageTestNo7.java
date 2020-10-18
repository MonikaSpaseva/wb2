package wb2.whatsmissing_subtestNo7;

import java.util.LinkedList;
import java.util.List;

public class ManageTestNo7 {
    private List<QuestionAndAnswerTestNo7> listQuestAndAnsNo1;

    public ManageTestNo7() {
        this.listQuestAndAnsNo1 = new LinkedList<>();
    }

    public void addAnswers(QuestionAndAnswerTestNo7 qANDa) {
        listQuestAndAnsNo1.add(qANDa);
    }

    public QuestionAndAnswerTestNo7 findQuestionByIndex(int indexNumber) {

        if (indexNumber > listQuestAndAnsNo1.size() || indexNumber < 0) {
            System.out.println("Прашањето не е најдено");
            return null;
        }
        return listQuestAndAnsNo1.get(indexNumber  - 1);
    }

    public void printListOfAnswers() {
        System.out.println("Листа со поени ");
        for (int i = 0; i < listQuestAndAnsNo1.size(); i++) {

            int posA = listQuestAndAnsNo1.get(i).getQuestion().indexOf("  ");
            String until =listQuestAndAnsNo1.get(i).getQuestion().substring(0, posA);

            String poen;
            if (listQuestAndAnsNo1.get(i).isCorrect()) {
                poen = "1 поен";
                System.out.println(until + "  --> " + poen);
            } else {
                poen = "0 поени";
                System.out.println(until + " --> " + poen);
            }
        }
    }


    public void printPointsForTestNo7() {
        int sum = 0;
        for (QuestionAndAnswerTestNo7 list : listQuestAndAnsNo1) {
            if (list.isCorrect()) {
                sum = sum + 1;
            }
        }
        System.out.println("7. Дополнување слики (поени) = " + sum  + "/15");
    }

     public int getPointsForTestNo7() {
         int sum = 0;
         for (QuestionAndAnswerTestNo7 list : listQuestAndAnsNo1) {
             if (list.isCorrect()) {
                 sum = sum + 1;
             }
         }
         return sum;
     }

    public void clear() {
        listQuestAndAnsNo1 = new LinkedList<>();
    }
}
