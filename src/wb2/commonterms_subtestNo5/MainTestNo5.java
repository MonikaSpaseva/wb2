package wb2.commonterms_subtestNo5;

import wb2.TableTestResults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class MainTestNo5 {
    private static Scanner scanner = new Scanner(System.in);
    private static List<QuestionAnswerSubtestNo5> list = new LinkedList<>();
    private static List<String> questions = new LinkedList<>();

    public static void main(String[] args) throws SQLException {

        questions.add("1. Јаболка - Крушка:".toUpperCase() +
                "\n\t2 поени: \n\t\t - овошје (плодови) \n\t\t - овошје со семки" +
                "\n\t1 поен: \n\t\t - храна \n\t\t - се јадат \n\t\t - имаат семки \n\t\t - имаат лушпа");
        questions.add("2. Куче - Маче:".toUpperCase() +
                "\n\t2 поени: \n\t\t - животни \n\t\t - цицачи \n\t\t - домашни животни \n\t\t - четириножни животни" +
                "\n\t1 поен: \n\t\t - влакнести се \n\t\t - имаат по 4 нозе \n\t\t - опашки \n\t\t - брзи се");
        questions.add("3. Пиво - Вино:".toUpperCase() +
                "\n\t2 поени: \n\t\t - алкохолни пијалоци  \n\t\t - опојни пијалоци" +
                "\n\t1 поен: \n\t\t - пијалоци \n\t\t - течности \n\t\t - двете се пијат \n\t\t - содржат алкохол \n\t\t - ги пиеме во друшво, во кафана");
        questions.add("4. ХАРТИЈА - ЈАГЛЕН:" +
                "\n\t2 поени: \n\t\t - јаглеродни соединенија  \n\t\t - гориво" +
                "\n\t1 поен: \n\t\t - согорливи се \n\t\t - со нив ложиме \n\t\t - од дрво се");
        questions.add("5. ПАНТОЛОНИ - КОШУЛА:" +
                "\n\t2 поени: \n\t\t - облека" +
                "\n\t1 поен: \n\t\t - направени се од ткаенина \n\t\t - ги облекуваме \n\t\t - го покриваат телото");
        questions.add("6. МАСА - СТОЛ:" +
                "\n\t2 поени: \n\t\t - мебел \n\t\t - делови од мебел" +
                "\n\t1 поен: \n\t\t - опрема за стан/куќа \n\t\t - ги употребуваме кога јадеме \n\t\t - се наоѓаат во собата во којашто јадеме");
        questions.add("7. КИЛОГРАМ - МЕТАР:" +
                "\n\t2 поени: \n\t\t - единици мерки  \n\t\t - мерки" +
                "\n\t1 поен: \n\t\t - нешто мерат \n\t\t - содржат помали мерни единици");
        questions.add("8. ВЕСНИК - РАДИО:" +
                "\n\t2 поени: \n\t\t - комуникациски средства  \n\t\t - средства за масовно поврзување \n\t\t - извори за јавни известувања" +
                "\n\t1 поен: \n\t\t - пренесуваат вести \n\t\t - слушат за занимација \n\t\t - прошируваат образование");
        questions.add("9. ОКО - УВО:" +
                "\n\t2 поени: \n\t\t - сетила  \n\t\t - сетилни органи \n\t\t - сетилни рецептори" +
                "\n\t1 поен: \n\t\t - делови на телото  \n\t\t - органи на телото \n\t\t - преку нив контактираме со надворешниот свет");
        questions.add("10. ПЛАНИНА - ЕЗЕРО:" +
                "\n\t2 поени: \n\t\t - топографски поими \n\t\t - природна земјина творба \n\t\t - географски земјини поими" +
                "\n\t1 поен: \n\t\t - глацијални формации (облици) \n\t\t - содржат вода \n\t\t - имаат дно");
        questions.add("11. Броеви - 49 - 121:".toUpperCase() +
                "\n\t2 поени: \n\t\t - квадратни броеви \n\t\t - целосно математички квадрати \n\t\t - броеви со непарен квадратен корен" +
                "\n\t1 поен: \n\t\t - непарни броеви \n\t\t - не се делат со 2");
        questions.add("12. Слобода - Правда:".toUpperCase() +
                "\n\t2 поени: \n\t\t - човекови идеали \n\t\t - друштвени вредности \n\t\t - апстрактни поими" +
                "\n\t1 поен: \n\t\t - демократски принципи \n\t\t - симболи на нашата заедница \n\t\t - двете начела се во врска со независност \n\t\t - граѓански права");


        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User1\\Desktop\\wb.db");

        TableTestResults tableTestResults = new TableTestResults(connection);

        printOptions();
        choose(tableTestResults);

    }


    public static void choose(TableTestResults tableTestResults) {
        boolean esc = false;

        while (!esc) {
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    esc = true;
                    break;
                case "1":
                    printOptions();
                    break;
                case "2":
                    testNo2();
                    break;
                case "3":
                    printListOfAnswers();
                    break;
                case "4":
                    changeAnswer();
                    break;
                case "5":
                    printPoints();
                    break;
                case "6":
                    tableTestResults.addResultTestNo5();
                    break;
                default:
                    System.out.println("Ве молиме внесете број (0 - 5)");
                    break;
            }
        }
    }

    public static void testNo2() {

        QuestionAnswerSubtestNo5 manage;

        ListIterator<String> itr = questions.listIterator();
        System.out.println();
        System.out.println("('2' - за 2 поени; '1' - за 1 поен; 'stop' - за да се прекине тестирањето)");
        System.out.println();
        while (itr.hasNext()) {
            String current = itr.next();
            boolean correct1Point = false;
            boolean correct2Points = false;
            System.out.println(current);
            String input = scanner.nextLine();
            if (input.equals("2")) {
                correct2Points = true;
            } else if (input.equals("1")) {
                correct1Point = true;
            } else if (input.equalsIgnoreCase("stop")) {
                System.out.println("Тестирањето беше прекинато, поените не беа зачувани");
                clear();
                break;
            }
            manage = new QuestionAnswerSubtestNo5(current, correct2Points, correct1Point);
            list.add(manage);
        }
        System.out.println("Тестирањето е завршено!");
        printPoints();
    }


    public static void printListOfAnswers() {
        System.out.println();
        System.out.println("Листа со поени: ");
        System.out.println();
        for (QuestionAnswerSubtestNo5 current : list) {
            int posA = current.getQuestionAndAnswer().indexOf(":");
            String until = current.getQuestionAndAnswer().substring(0, posA);
            if (current.isCorrectTwoPoints()) {
                System.out.println(until + " - 2 поени");
            } else if (current.isCorrectOnePoint()) {
                System.out.println(until + " - 1 поен");
            } else {
                System.out.println(until + " - 0 поени");
            }
        }
    }

    public static void printPoints() {
        int sum = 0;
        for (QuestionAnswerSubtestNo5 l : list) {
            if (l.isCorrectTwoPoints()) {
                sum += 2;
            } else if (l.isCorrectOnePoint()) {
                sum += 1;
            }
        }
        System.out.println();
        System.out.println("Заеднички поими (поени) = " + sum + ("/24"));
    }
    public static int getPoints() {
        int sum = 0;
        for (QuestionAnswerSubtestNo5 l : list) {
            if (l.isCorrectTwoPoints()) {
                sum += 2;
            } else if (l.isCorrectOnePoint()) {
                sum += 1;
            }
        }
        return sum;
    }

    public static void printOptions() {
        System.out.println("0 - исклучи");
        System.out.println("1 - види опции");
        System.out.println("2 - тестирај");
        System.out.println("3 - види листа со поени");
        System.out.println("4 - смени одговор");
        System.out.println("5 - испринтај резултат");
    }


    public static QuestionAnswerSubtestNo5 findIndex(int index) {
        if (index > list.size() || index < 0) {
            return null;
        }

        return list.get(index - 1);

    }

    public static void changeAnswer() {
        try {
            System.out.println("Впишете го бројот на прашањето на кое што сакате да му го смените одговорот");

            int index = scanner.nextInt();
            QuestionAnswerSubtestNo5 change = findIndex(index);
            scanner.nextLine();

            if (change != null) {
                int posA = change.getQuestionAndAnswer().indexOf(":");
                String until = change.getQuestionAndAnswer().substring(0, posA);

                if (change.isCorrectTwoPoints()) {
                    System.out.println(until + " - 2 поени");
                } else if (change.isCorrectOnePoint()) {
                    System.out.println(until + " - 1 поен");
                } else {
                    System.out.println(until + " - 0 поени");
                }

                System.out.println("-За да смените во 0 поени притиснете '0'\n-За да смените во 1 поен притиснете '1'\n-За да смените во 2 поени притиснете '2'");
                String changePoints = scanner.nextLine();

                switch (changePoints) {
                    case "0":
                        change.zeroPoints();
                        System.out.println("Промената беше успешна");
                        printPoints();
                        break;
                    case "1":
                        change.onePoint();
                        System.out.println("Промената беше успешна");
                        printPoints();
                        break;
                    case "2":
                        change.twoPoints();
                        System.out.println("Промената беше успешна");
                        printPoints();
                        break;
                    default:
                        System.out.println("Пристиснете 4 за повторно бирање");
                        break;

                }
            } else {
                System.out.println("Прашањето не е најдено. Притиснете 4 за повторно бирање, 1 за да ги видите опциите, 0 за излез");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ве молиме внесете број ");
            scanner.nextLine();
            changeAnswer();
        }
    }

    public static void clear() {
        list = new LinkedList<>();
    }
}
