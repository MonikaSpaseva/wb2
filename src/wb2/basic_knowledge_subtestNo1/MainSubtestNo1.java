package wb2.basic_knowledge_subtestNo1;

import wb2.TableTestResults;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;


public class MainSubtestNo1 {

    private static Scanner scanner = new Scanner(System.in);
    private static ManageQAndATestNo1 manageQAndATestNo1 = new ManageQAndATestNo1();
    public static List<String> questions = new LinkedList<>();



    public static void main(String[] args) throws SQLException {

        questions.add("1. Колку денови има во неделата?");
        questions.add("2. Колку месеци има во годината?");
        questions.add("3. Кои се четирите годишни времиња?");
        questions.add("4. Која е улогата на желудникот?");
        questions.add("5. На која страна на светот заоѓа сонцето?");
        questions.add("6. Кој е главен град на Македонија?");
        questions.add("7. Кога го славиме празникот на трудот?");
        questions.add("8. Колку км содржи еден тон?");
        questions.add("9. Зошто зејтинот плива над водата?");
        questions.add("10. Колку децилитри содржи еден литар?");
        questions.add("11. Која е точката на вриење на водата?");
        questions.add("12. Колку жители живеат во Македонија?");
        questions.add("13. Што славиме на 11ти октомври?");
        questions.add("14. Колку парчиња содржи едно купче?");
        questions.add("15. Кој ја напишал 'Браќа Карамазови'?");
        questions.add("16. На кој континент се наоѓа Индија?");
        questions.add("17. Кој е главен град на Грција?");
        questions.add("18. Што е Ватикан?");
        questions.add("19. Колку км е долг патот Скопје-Велес?");
        questions.add("20. Колку недели има во годината?");
        questions.add("21. Од што се добива гума?");
        questions.add("22. Што е барометар?");
        questions.add("23. Што е алиби?");
        questions.add("24. Кој ја напишал 'Степскиот Волк'?");
        questions.add("25. Кој бил Џингис Кан?");
        questions.add("26. Што е хиероглиф?");
        questions.add("27. Што е етнологија?");


        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User1\\Desktop\\wb.db");
        TableTestResults tableTestResults = new TableTestResults(connection);

        printOptions();
        choose(tableTestResults);

    }

    public static void choose(TableTestResults tableTestResults) {
        boolean quit = false;
        String option;

        while (!quit) {
            option = scanner.nextLine();

            switch (option) {
                case "0":
                    quit = true;
                    break;
                case "1":
                    printOptions();
                    break;
                case "2":
                    testNo1();
                    break;
                case "3":
                    manageQAndATestNo1.printListOfAnswers();
                    break;
                case "4":
                    changeAnswer();
                    break;
                case "5":
                    manageQAndATestNo1.printPointsForTestNo1();
                    break;
                case "6":
//                    writeResultToFile();
                    tableTestResults.addResultTestNo1(manageQAndATestNo1);
                    break;
                default:
                    System.out.println();
                    System.out.println("Ве молиме внесете број (0 - 5); 1 - за да видите опции, 0 - за излез");
                    break;
            }
        }
    }


    public static void testNo1() {

        ListIterator<String> itr = questions.listIterator();
        QuestionAndAnswerTestNo1 manage;

        System.out.println("('1'- ако одговорот е точен, 'stop' - за да се прекине тестот)");
        System.out.println();
        while (itr.hasNext()) {
            String question = itr.next();
            System.out.println(question);

            boolean correct = false;
            String yesNo = scanner.nextLine();
            if (yesNo.equals("1")) {
                correct = true;
            } else if (yesNo.equals("stop")) {
                System.out.println("Тестирањето беше прекинато, резултатите не беа зачувани");
                manageQAndATestNo1.clear();
                break;
            }

            manage = new QuestionAndAnswerTestNo1(question, correct);
            manageQAndATestNo1.addAnswers(manage);

        }
        System.out.println("Тестирањето е завшено");
        manageQAndATestNo1.printPointsForTestNo1();

    }

    public static void changeAnswer() {
        System.out.println("Напиши го бројот на прашањето на кое што сакаш да му го смениш одговорот ");

        try {
            int index = scanner.nextInt();
            QuestionAndAnswerTestNo1 item = manageQAndATestNo1.findQuestionByIndex(index);

            if (item != null) {
                if (item.isCorrect()) {
                    System.out.println("Одговорот на прашањето " + "'" + item.getQuestion() + "' беше променет од точен(1 поен) во неточен(0 поени)");
                } else {
                    System.out.println("Одговорот на прашањето " + "'" + item.getQuestion() + "' беше променет од неточен(0 поени) во точен(1 поен)");
                }
                item.toggle();
                manageQAndATestNo1.printPointsForTestNo1();
            }
        } catch (RuntimeException e) {
            System.out.println("(Ве молиме внесете број)");
            scanner.nextLine();
            changeAnswer();
        }
    }

    public static void printOptions() {
        System.out.println();
        System.out.println("0 - излези од апликацијата");
        System.out.println("1 - види опции");
        System.out.println("2 - почни со тестирање ");
        System.out.println("3 - да ја видиш листата со одговори");
        System.out.println("4 - да смениш одговор");
        System.out.println("5 - види резултат");
        System.out.println("6 - зачувај резултат во фајл ");
    }

    public static void writeResultToFile() {
        try  {
            FileWriter fileWriter = new FileWriter("basic_knowledge.txt");

            int result = manageQAndATestNo1.pointsForTestNo1();

            String bla = " 1 Поученост " + result +  " поени. " + "\n";
            fileWriter.write(bla);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Запишано во фајл");
        } catch (IOException e) {
            System.out.println("Резултатот не беше запишан.");
        }
    }
}

