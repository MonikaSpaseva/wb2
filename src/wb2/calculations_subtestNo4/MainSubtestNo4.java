package wb2.calculations_subtestNo4;

import wb2.TableTestResults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class MainSubtestNo4 {

    private static Scanner scanner = new Scanner(System.in);
    private static ManageSubtestNo4 manage = new ManageSubtestNo4();
    private static List<String> mathProblems = new LinkedList<>();

    public static void main(String[] args) throws SQLException {
        mathProblems.add("1. Едно дете имало 4 денари. Добило Уште 2. Колку денари има сега?\n" +
                "Точен одговор: 6 денари              (Временско ограничување 15 сек.)");
        mathProblems.add("2. Пред една куќа има 12 автомобили. 5 си одат. Уште колку автомобили стојат пред куќата?\n" +
                "Точен одговор: 7 автомобили          (Временско ограничување 15 сек.)");
        mathProblems.add("3. Ако едно чоколатце чини 7 денари. Колку ќе чинат 3 чоколатца?\n" +
                "Точен одговор: 21 денар              (Временско ограничување 15 сек.)");
        mathProblems.add("4. На едно брдо има 25 скијачи. 11 си одат дома. Колку скијачи остануваат на брдото?\n" +
                "Точен одговор: 14 скијачи            (Временско ограничување 30 сек.)");
        mathProblems.add("5. Колку саати треба да пешачите до место кое е оддалечено 36 км ако на саат проаѓате по 4 км?\n" +
                "Точен одговор: 9 часа                (Временско ограничување 30 сек.)");
        mathProblems.add("6. Купувате 3 книги. Секоја книга чини по 300 ден. Вие сте дале 1000 ден.\n   Колку денари ќе добиете назад?\n" +
                "Точен одговор: 100 денари            (Временско ограничување 60 сек.)");
        mathProblems.add("7. Ако 3 сандука со овошје тежат 5 кг, колку кг се тешки 24 сандуци со овошје?\n" +
                "Точен одговор: 40кг                  (Временско ограничување 60 сек.)");
        mathProblems.add("8. Некој купил половен велосипед за 2 третини од неговата првобитна цена. За тоа платил 4000.\n   Колку денати ќе чини нов велосипед??\n" +
                "Точен одговор: 6000 денари           (Временско ограничување 20 сек.)");
        mathProblems.add("9. Ako двајца работници сложуваат за 1 ипол минута 6 даски, колку даски би сложиле 5 работници за 30 мин?\n" +
                "Точен одговор: 300 даски             (Временско ограничување 120 сек.)");
        mathProblems.add("10. Милан и Петар почнале да играат карти секој со по 27 денари. \n    Се договориле после секоја партија губитникот да му плати на победникот една третина од моменталната сума со која што располага.\n    Милан победил во првите 3 партии. Колку денари има Петар на почетокот на 4тата партија?\n" +
                "Точен одговор: 8 денари              (Временско ограничување 120 сек.)");

        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User1\\Desktop\\wb.db");
        TableTestResults tableTestResults = new TableTestResults(connection);

        printOptions();
        change(tableTestResults);
    }

    public static void change(TableTestResults tableTestResults) {
        boolean quit = false;
        while (!quit) {
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    quit = true;
                    break;
                case "1":
                    printOptions();
                    break;
                case "2":
                    instructions();
                    break;
                case "3":
                    takeTest();
                    break;
                case "4":
                    manage.printPoints();
                    break;
                case "5":
                    manage.printListOfAnswers();
                    break;
                case "6":
                    changeAnswer();
                    break;
                case "7":
                   tableTestResults.addResultTestNo4(manage);
                    break;
                default:
                    System.out.println("Ве молиме внесете број од 0 - 7; 1 - за да видите опции, 0 - за излез");
                    break;
            }
        }
    }


    public static void takeTest() {
        QuestionAndAnswerSubtestNo4 manageSubtestNo4;
        ListIterator<String> itr = mathProblems.listIterator();
        System.out.println();
        System.out.println("(За точен одговор на првото прашање притиснете '1', за точен одговор на прашањата од 2 - 10 притиснете '2', за неточен одговор притиснете '0'; \n'stop' - за да се прекине тестирањето)");
        System.out.println();

        while (itr.hasNext()) {
            String current = itr.next();

            boolean correctOnePoint = false;
            boolean correctTwoPoints = false;
            boolean plusOne = false;
            boolean plusTwo = false;

            System.out.println(current);
            String input = scanner.nextLine();

            if ((current.equals(findQuestionInList(7))) && input.equals("2")) {
                System.out.println("Додатни поени за брзина:");
                System.out.println("1 - 5 сек. -> додадете '2'; 6 - 12 сек. -> додадете '1'; '0' - за повеќе од 12 сек.");
                String input2 = scanner.nextLine();
                if (input2.equals("2")) {
                    plusTwo = true;
                } else if (input2.equals("1")) {
                    plusOne = true;
                }
                correctTwoPoints = true;
            } else if ((current.equals(findQuestionInList(8))) && input.equals("2")) {
                System.out.println("Додатни поени за брзина:");
                System.out.println("1 - 6 сек., додадете '2'; 7 - 15 сек. додадете '1'; '0' - за повеќе од 15 сек.");
                String input2 = scanner.nextLine();
                if (input2.equals("2")) {
                    plusTwo = true;
                } else if (input2.equals("1")) {
                    plusOne = true;
                }
                correctTwoPoints = true;
            } else if ((current.equals(findQuestionInList(9))) && input.equals("2")) {
                System.out.println("Додатни поени за брзина:");
                System.out.println("1 - 20 сек., додадете '2'; 21 - 49 сек. додадете '1'; '0' - за повеќе од 49 сек.");
                String input2 = scanner.nextLine();
                if (input2.equals("2")) {
                    plusTwo = true;
                } else if (input2.equals("1")) {
                    plusOne = true;
                }
                correctTwoPoints = true;
            } else if ((current.equals(findQuestionInList(10))) && input.equals("2")) {
                System.out.println("Додатни поени за брзина:");
                System.out.println("1 - 18 сек., додадете '2'; 19 - 40 сек. додадете '1', '0' - за повеќе од 40 сек.");
                String input2 = scanner.nextLine();
                if (input2.equals("2")) {
                    plusTwo = true;
                } else if (input2.equals("1")) {
                    plusOne = true;
                }
                correctTwoPoints = true;
            } else if ((input.equals("2") || input.equals("0")) && !current.equals(findQuestionInList(1))) {
                if (input.equals("2")) {
                    correctTwoPoints = true;
                }
            } else if (current.equals(findQuestionInList(1)) && (input.equals("1") || input.equals("0"))) {
                if (input.equals("1")) {
                    correctOnePoint = true;
                }
            } else if (input.equalsIgnoreCase("stop")) {
                System.out.println("Тестирањето беше прекинато, резултатите не беа зачувани");
                manage.clear();
                break;
            } else {
                System.out.println("Додадовте повеќе од 1 поен на првото прашање или помалку/повеќе од 2 поени на прашањата од 2 - 10\n" +
                        "На истото нема да му бидат додадени поени. Резултатот можете да го промените по завршување на тестирањето.");
                System.out.println();
            }
            manageSubtestNo4 = new QuestionAndAnswerSubtestNo4(current, correctOnePoint, correctTwoPoints, plusOne, plusTwo);
            manage.addAnswer(manageSubtestNo4);
        }
        System.out.println("Тестирањето е завршено!");
        manage.printPoints();
    }


    public static String findQuestionInList(int index) {
        if (index > mathProblems.size() || index < 0) {
            return null;
        }
        return mathProblems.get(index - 1);
    }

    public static void changeAnswer() {
        try {
            System.out.println("Впишете го бројот на прашањето на кое што сакате да му го смените одговорот");

            int index = scanner.nextInt();
            QuestionAndAnswerSubtestNo4 change = manage.findByIndex(index);
            scanner.nextLine();

            if (change != null) {
                int posA = change.getMathProblem().indexOf("?");
                String until = change.getMathProblem().substring(0, posA);

                if (change.isTwoPoints() && change.isPlusTwo()) {
                    System.out.println(until + " - 4 поени");
                } else if (change.isTwoPoints() && change.isPlusOne()) {
                    System.out.println(until + " - 3 поени");
                } else if (change.isTwoPoints()) {
                    System.out.println(until + " - 2 поени");
                } else if (change.isOnePoint()) {
                    System.out.println(until + " - 1 поен");
                } else {
                    System.out.println(until + " - 0 поени");
                }

                System.out.println("-За да ставите 4 поени притиснете '4' \n-За да ставите 3 поени притиснете '3'\n-За да ставите 2 поени притиснете '2'\n-За да ставите 1 поен '1'\n-За да ставите 0 поени притиснете '0'");
                String changePoints = scanner.nextLine();

                switch (changePoints) {
                    case "0":
                        change.zeroPoints();
                        System.out.println("Промената беше успешна");
                        manage.printPoints();
                        break;
                    case "1":
                        change.onePoint();
                        System.out.println("Промената беше успешна");
                        manage.printPoints();
                        break;
                    case "2":
                        if (!change.getMathProblem().equals(findQuestionInList(1))) {
                            change.twoPoints();
                            System.out.println("Промената беше успешна");
                            manage.printPoints();
                        } else {
                            System.out.println("Максималниот број на поени на прашањето број 1 се '1'.");
                        }
                        break;
                    case "3":
                        if (change.getMathProblem().equals(findQuestionInList(7)) || change.getMathProblem().equals(findQuestionInList(7)) || change.getMathProblem().equals(findQuestionInList(8)) || change.getMathProblem().equals(findQuestionInList(9)) || change.getMathProblem().equals(findQuestionInList(10))) {
                            change.threePoints();
                            System.out.println("Промената беше успешна");
                            manage.printPoints();
                        } else if (change.getMathProblem().equals(findQuestionInList(1))) {
                            System.out.println("Максималниот број на поени на прашањето 1 се '1'");
                        } else {
                            System.out.println("Максималниот број на поени на прашањата od 2 - 6 се '2'");
                        }
                        break;
                    case "4":
                        if (change.getMathProblem().equals(findQuestionInList(7)) || change.getMathProblem().equals(findQuestionInList(7)) || change.getMathProblem().equals(findQuestionInList(8)) || change.getMathProblem().equals(findQuestionInList(9)) || change.getMathProblem().equals(findQuestionInList(10))) {
                            change.fourPoints();
                            System.out.println("Промената беше успешна");
                            manage.printPoints();
                        } else if (change.getMathProblem().equals(findQuestionInList(1))) {
                            System.out.println("Максималниот број на поени на прашањето 1 се '1'");
                        } else {
                            System.out.println("Максималниот број на поени на прашањата od 2 - 6 се '2'");
                        }
                        break;
                    default:
                        System.out.println("Пристиснете 6 за повторно бирање, 1 за да ги видите опциите, 0 за излез");
                        break;
                }
            } else {
                System.out.println("Прашањето не беше пронајдено");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ве молиме внесете број ");
            scanner.nextLine();
            changeAnswer();
        }
    }


    public static void instructions() {
        System.out.println("- Задачите од 1 -7 поставете ги усно, а задачите од 8 - 10 писмено.");
        System.out.println("- Писмените задачи испитаникот треба да ги прочита на глас.");
        System.out.println("- Времето на решавање на поединечните задачи е ограничено.");
        System.out.println("- Со мерење на време почнувате откако ќе ја прочитате задачата." +
                "(Доколку треба да ја повторите задачата,\n времето ќе го мерите од моментот кога сте завршиле со читање првиот пат.)");
        System.out.println("- Кај писмените задачи времето ќе почнете да го мерите откако испитаникот ќе го прочита текстот.");
        System.out.println("- Завршете со тестирањето доколку испитаникот не може да одговори на 3 последователни задачи.");
        System.out.println();
        System.out.println("Оценување: ");
        System.out.println("  - За правилно решение на задачата бр. 1, ставете 1 бод. За правилно решение на задачите од 2 до 10 ставете 2 бода.");
        System.out.println("  - За правилно решение на задачите од 7 - 10 земете ги во предвид и дополнителните поени за брзина на решавање.");
        System.out.println("  - Одговорот е важечки и ако испитаникот во дозволениот временски интервал ја поправи грешката.");
    }

    public static void printOptions() {
        System.out.println("0 - за излез");
        System.out.println("1 - види опции");
        System.out.println("2 - прочитај инструкции");
        System.out.println("3 - тестирај");
        System.out.println("4 - види поени");
        System.out.println("5 - испринтај листа со поени");
        System.out.println("6 - смени одговор");
    }
}
