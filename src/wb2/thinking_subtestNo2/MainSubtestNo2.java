package wb2.thinking_subtestNo2;

import wb2.TableTestResults;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class MainSubtestNo2 {
    private static Scanner scanner = new Scanner(System.in);
    private static ManageSubtestNo2 manageL = new ManageSubtestNo2();
    private static List<String> questions = new LinkedList<>();

    public static void main(String[] args) throws SQLException {
        questions.add("1. Што треба да направите ако изгубите саат којшто сте го позајмиле од пријател?".toUpperCase() +
                "\n\t2 поени: \n\t\t - ќе купам нов \n\t\t - ќе набавам друг \n\t\t - ќе го платам \n\t\t - ќе го надоместам" +
                "\n\t1 поен: \n\t\t - ќе пријавам во полиција \n\t\t - ќе пробам да го најдам");
        questions.add("2. Зошто е подобро да се изгради куќа од цигли отколку од дрва?".toUpperCase() +
                "\n\t2 поени: \n\t\t - поиздржлива е, не бара многу поправки \n\t\t - поцврста, потрајна \n\t\t - помалку осетлива на оган" +
                "\n\t1 поен: \n\t\t - поцврста \n\t\t - побезбедна");
        questions.add("3. Зошто е добро луѓето да штедат пари?".toUpperCase() +
                "\n\t2 поени: \n\t\t - средства за 'црни' денови  \n\t\t - за непредвидливи неопходни трошоци \n\t\t - за поголема сигурност \n\t\t - за секој случај" +
                "\n\t1 поен: \n\t\t - човек никогаш не знае што може да се случи \n\t\t - да можам да купам автомобил \n\t\t - во случај на болест");
        questions.add("4. ШТО БИ ТРЕБАЛО ДА НАПРАВИТЕ АКО ВИДИТЕ ДЕКА ВОЗ СЕ ПРИБЛИЖУВА НА МЕСТО КАДЕ ШТО ПРУГАТА Е РАСИПАНА?" +
                "\n\t2 поени: \n\t\t - да мавтам со рацете или со некаков предмет со цел возот да застане  \n\t\t - да мавтам и да викам по машиновозачот \n\t\t - да се приближам до возот и со нешто да ги предупредам луѓето во него \n\t\t - да сигнализирам опасност" +
                "\n\t1 поен: \n\t\t - да го застанам возот, без објаснување \n\t\t - да викам по машиновозачот \n\t\t - да викнам железничар, да го сопре возот \n\t\t - да ја известам железничката станица да го сопре возот");
        questions.add("5. ЗОШТО ЗЕМЈИШТЕТО ВО ГРАДОТ Е ПОСКАПО ОТКОЛКУ ЗЕМЈИШТЕТО ВО СЕЛО?" +
                "\n\t2 поени: \n\t\t - во градот е поголема побарувачката  \n\t\t - повеќе луѓе сакаат да го купат \n\t\t - во градот е потешко да се добие (поголема побарувачка, помалку понуди)" +
                "\n\t1 поен: \n\t\t - во град живеат повеќе луѓе \n\t\t - во градот просторот е ограничен \n\t\t - поголеми можности за работа");
        questions.add("6. ЗОШТО Е ПОДОБРО ДА СЕ ПОКЛОНАТ ПАРИ НА ЦРВЕН КРСТ ОТКОЛКУ НА ПРОСЈАК НА УЛИЦА?" +
                "\n\t2 поени: \n\t\t - Црвен крст како друштвена организација им овозможува на дарителите попогоден облик добротворство, просјак на улица може да биде преварант  \n\t\t - се грижи за оние на кои им е најпотребна помош, додека просјакот на улица можеби и не се наоѓа во толку тешка ситуација \n\t\t - просјакот на улица може да ги потроши парите за алкохол, додека црвен крст им помага на оние на коишто помошта им е најпотребна" +
                "\n\t1 поен: \n\t\t - просјакот на улица може да е алкохоличар \n\t\t - црвен крст знае кому му е помошта најпотребна \n\t\t - можеме да бидеме сигурни дека црвен крст же ги потроши парите за прави цели");
        questions.add("7. ШТО БИ НАПРАВИЛЕ ДОКОЛКУ ВАШ БЛИЗОК ПРИЈАТЕЛ ВИ ПОБАРА НЕШТО ШТО ГО НЕМАТЕ?" +
                "\n\t2 поени: \n\t\t - се би направил да го најдам тоа што ми го побарал  \n\t\t - би му кажал дека немам, но дека ќе се потрудам да најдам \n\t\t - би го позајмил" +
                "\n\t1 поен: \n\t\t - ќе го упатам каде што го има тоа што го бара \n\t\t - ќе го советувам каде може да го најде");
        questions.add("8. ЗОШТО ЛУЃЕТО ТРЕБА ДА ПЛАЌААТ ДАНОК?" +
                "\n\t2 поени: \n\t\t - да го дадат својот дел на заедницата (држава, друштва, општини)  \n\t\t - за државата да може да финансира заеднички(јавни) потреби" +
                "\n\t1 поен: \n\t\t - за изградба на болници, патишта \n\t\t - за здравство и просвета");
        questions.add("9. ЗОШТО СЕ ПОТРЕБНИ ЗАКОНСКИ ПРОПИСИ?" +
                "\n\t2 поени: \n\t\t - регулација на заедниците  \n\t\t - регулирање на животот на поединецот во комплексна заедница \n\t\t - го заштитуваат животот и личните посеств на граѓанинот \n\t\t - во секоја заедница се потребни општи правила за доброто на сите" +
                "\n\t1 поен: \n\t\t - да спречуваат луѓе да прават злосторства  \n\t\t - да ги заштитат граѓаните \n\t\t - да се спречи слободната волја на поединецот \n\t\t - без закон луѓето би живееле во хаос \n\t\t -  законите овозможуваат ред и мир");
        questions.add("10. ЗОШТО ТРЕБА ДА ГО ИСПОЛНИТЕ ВЕТЕНОТО?" +
                "\n\t2 поени: \n\t\t - социјалните меѓусебни односи во голема мера се базираат на меѓусебна доверба \n\t\t - со исполнување на ветеното се сочувува довербата во човекот \n\t\t - исполнување на ветеното е корисно затоа што ја зајакнува довербата меѓу луѓето \n\t\t - договор помеѓу двајца луѓе е  на некој начин премолчен договор којшто не смееме да го изневериме" +
                "\n\t1 поен: \n\t\t - лична чест \n\t\t - морална обврска \n\t\t - дадениот збор е обврска  \n\t\t - за луѓето да веруваат во вашите идни ветувања");

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
                    manageL.printListOfAnswers();
                    break;
                case "4":
                    changeAnswer();
                    break;
                case "5":
                    manageL.printPoints();
                    break;
                case "6":
                    writeToFile();
                    tableTestResults.addResultTestNo2(manageL);
                    break;
                default:
                    System.out.println("Ве молиме внесете број од 0 - 5 (1 - за да видите опции, 0 - за излез)");
                    break;
            }
        }
    }

    public static void testNo2() {

        QuestionAndAnswerSubtestNo2 manage;

        ListIterator<String> itr = questions.listIterator();
        System.out.println();
        System.out.println("(2 - за 2 поени; 1 - за 1 поен; stop - за да се прекине тестирањето)");
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
                System.out.println("Тестирањето беше прекинато, резултатите не беа зачувани");
                manageL.clear();
                break;
            }
            manage = new QuestionAndAnswerSubtestNo2(current, correct2Points, correct1Point);
            manageL.addAnswer(manage);
        }
        System.out.println("Тестирањето е завршено!");
        manageL.printPoints();
    }

    public static void printOptions() {
        System.out.println("0 - исклучи");
        System.out.println("1 - види опции");
        System.out.println("2 - тестирај");
        System.out.println("3 - види листа со поени");
        System.out.println("4 - смени одговор");
        System.out.println("5 - испринтај резултат");
        System.out.println("6 - запиши резултат во фајл");
    }

    public static void changeAnswer() {
        try {
            System.out.println("Впишете го бројот на прашањето на кое што сакате да му го смените одговорот");

            int index = scanner.nextInt();
            QuestionAndAnswerSubtestNo2 change = manageL.findIndex(index);

            scanner.nextLine();

            if (change != null) {
                int posA = change.getQuestion().indexOf("?");
                String until = change.getQuestion().substring(0, posA);

                if (change.isAnswerTwoPoints()) {
                    System.out.println(until + " - 2 поени");
                } else if (change.isIsAnswerOnePoint()) {
                    System.out.println(until + " - 1 поен");
                } else {
                    System.out.println(until + " - 0 поени");
                }

                System.out.println("-За да ставите 2 поени притиснете '2'\n-За да ставите 1 поен '1'\n-За да ставите 0 поени притиснете '0'");
                String changePoints = scanner.nextLine();

                switch (changePoints) {
                    case "0":
                        change.zeroPoints();
                        System.out.println("Промената беше успешна");
                        manageL.printPoints();
                        break;
                    case "1":
                        change.onePoint();
                        System.out.println("Промената беше успешна");
                        manageL.printPoints();
                        break;
                    case "2":
                        change.twoPoints();
                        System.out.println("Промената беше успешна");
                        manageL.printPoints();
                        break;
                    default:
                        System.out.println("Пристиснете 4 за повторно бирање, 1 за да ги видите опциите, 0 за излез");
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

    public static void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("thinking.txt");

            int result = manageL.getPoints();
            String bla = "2 Сфаќање " + result + " поени";
            fileWriter.write(bla);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Запишано во фајл");
        } catch (IOException e) {
            System.out.println("Резултатот не беше запишан.");
        }
    }
}

