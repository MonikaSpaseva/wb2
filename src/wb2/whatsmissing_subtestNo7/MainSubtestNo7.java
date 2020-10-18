package wb2.whatsmissing_subtestNo7;


import wb2.TableTestResults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class MainSubtestNo7 {

    private static Scanner scanner = new Scanner(System.in);
    private static ManageTestNo7 manageTestNo7 = new ManageTestNo7();
    public static List<String> pictures = new LinkedList<>();

    public static void main(String[] args) throws SQLException {

        pictures.add("1. девојка        (уста)");
        pictures.add("2. мачка          (бркови)");
        pictures.add("3. врата          (шарка)");
        pictures.add("4. ножици         (завртка)");
        pictures.add("5. петел          (мамуза)");
        pictures.add("6. риба           (грбна перка)");
        pictures.add("7. капут          (дупки за копчиња)");
        pictures.add("8. мува           (пипци)");
        pictures.add("9. крава          (неразделено копито)");
        pictures.add("10.карти          (седмиот знак)");
        pictures.add("11.шешир          (трака)");
        pictures.add("12.термометар     (жива)");
        pictures.add("13.чадор          (жици)");
        pictures.add("14.профил         (веѓи)");
        pictures.add("15.куќа           (сенка од дрво)");

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
                    testNo7();
                    break;
                case "3":
                    manageTestNo7.printListOfAnswers();
                    break;
                case "4":
                    changeAnswer();
                    break;
                case "5":
                    manageTestNo7.printPointsForTestNo7();
                    break;
                case "6":
                    tableTestResults.addResultTestNo7(manageTestNo7);
                    break;
                default:
                    System.out.println();
                    System.out.println("Ве молиме внесете број (0 - 6); (1 - за да ги видите опциите, 0 - за излез)");
                    break;
            }
        }
    }


    public static void testNo7() {

        ListIterator<String> itr = pictures.listIterator();
        QuestionAndAnswerTestNo7 manage;

        System.out.println("('1'- ако одговорот е точен, 'stop' - за да се прекине тестот");
        System.out.println();
        while (itr.hasNext()) {
            String question = itr.next();
            System.out.println("   Слика     -    Точен одговор");
            System.out.println(question);

            boolean correct = false;
            String yesNo = scanner.nextLine();
            if (yesNo.equals("1")) {
                correct = true;
            } else if (yesNo.equals("stop")) {
                System.out.println("Тестирањето беше прекинато, резултатите не беа зачувани");
                manageTestNo7.clear();
                break;
            }

            manage = new QuestionAndAnswerTestNo7(question, correct);
            manageTestNo7.addAnswers(manage);
        }

        System.out.println("Тестирањето е завшено");
        manageTestNo7.printPointsForTestNo7();
    }

    public static void changeAnswer() {
        System.out.println("Напиши го бројот на прашањето на кое што сакаш да му го смениш одговорот ");

        try {
            int index = scanner.nextInt();
            QuestionAndAnswerTestNo7 item = manageTestNo7.findQuestionByIndex(index);

            int posA = item.getQuestion().indexOf("  ");
            String until = item.getQuestion().substring(0, posA);


            if (item.isCorrect()) {
                System.out.println("Одговорот на прашањето " + "'" + until + "' беше променет од точен(1 поен) во неточен(0 поени)");
            } else {
                System.out.println("Одговорот на прашањето " + "'" + until + "' беше променет од неточен(0 поени) во точен(1 поен)");
            }
            item.toggle();
            manageTestNo7.printPointsForTestNo7();

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
        System.out.println("6 - запиши резултат");
    }
}

