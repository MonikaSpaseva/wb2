package wb2.memory_subtestNo3;

import wb2.TableTestResults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainSubtestNo3 {

    private static Scanner scanner = new Scanner(System.in);
    private static int result1 = 0;
    private static int result2 = 0;


    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User1\\Desktop\\wb.db");

        TableTestResults tableTestResults = new TableTestResults(connection);

        printOptions();
        choose(tableTestResults);
    }

    private static void choose(TableTestResults tableTestResults) {
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
                    numbersFromFirstToLast();
                    break;
                case "4":
                    addPointsForTestNo1();
                    break;
                case "5":
                    numbersFromLastToFirst();
                    break;
                case "6":
                    addPointsForTestNo2();
                    break;
                case "7":
                    printResult();
                    break;
                case "8":
                    addPlusTestNo1();
                    break;
                case "9":
                    addPlusTestNo2();
                    break;
                case "10":
                    minusTestNo1();
                    break;
                case "11":
                    minusTestNo2();
                    break;
                case "12":
                    tableTestResults.addResultTestNo3();
                    break;
                default:
                    System.out.println("Ве молиме внесете број од 0 - 12");
                    printOptions();
                    break;
            }
        }
    }

    public static void instructions() {
        System.out.println("Кажете му на испитаникот: \n\t\t" + " 'Ќе ви кажам неколку броеви. Слушајте ме внимателно. Кога ќе завршам повторете ги броевите по истиот редослед'");
        System.out.println();
        System.out.println("Поединечните броеви ги изговараме во интервал од една секунда." +
                " Доколку испитаникот правилно го повтори првиот ред од задачата со 3 броја, \nпродолжете со првиот ред од задачата со 4 броеви итн." +
                "\nДоколку испитаникот не може да го повтори првиот ред броеви, прочитајте му го вториот ред од истата задача.\nДоколку правилно го повтори вториот ред, продолжете со следната, потешка задача.\n" +
                "Завршете го тестирањето, ако испитаникот не може да одговори на ниту една од двете варијанти на иста задача");

        System.out.println();
        System.out.println("Бодирање: \n" +
                "Во зависност од тоа колку броеви успеал да запамти по ред (нанапред или наназад) толку бодови се добиваат\n\t" +
                "Пр.: Ако од броевите нанапред успеал да запамти 6 по ред, се добиваат 6 бода;\n Ако од броевите наназад успеал да запамти 4, се добиваат 4 бода\n" +
                " Резултатот од субтестот Помнење ќе биде 10 (6 + 4)");
    }

    public static void numbersFromFirstToLast() {
        System.out.println("A. Броеви нанапред: ");
        System.out.println();
        System.out.println("(3) 3 - 8 - 6");
        System.out.println("    2 - 6 - 1");
        System.out.println();
        System.out.println("(4) 5 - 9 - 1 - 7");
        System.out.println("    6 - 2 - 5 - 8");
        System.out.println();
        System.out.println("(5) 8 - 4 - 2 - 3 - 9");
        System.out.println("    5 - 2 - 1 - 8 - 6");
        System.out.println();
        System.out.println("(6) 3 - 1 - 9 - 2 - 7 - 4");
        System.out.println("    7 - 9 - 6 - 4 - 8 - 3");
        System.out.println();
        System.out.println("(7) 2 - 3 - 7 - 6 - 9 - 3 - 8");
        System.out.println("    9 - 1 - 5 - 3 - 9 - 2 - 4");
        System.out.println();
        System.out.println("(8) 1 - 6 - 4 - 5 - 9 - 7 - 6 - 3");
        System.out.println("    2 - 9 - 7 - 6 - 3 - 1 - 5 - 4");
        System.out.println();
        System.out.println("(9) 5 - 3 - 8 - 7 - 1 - 9 - 4 - 6 - 2");
        System.out.println("    4 - 9 - 2 - 6 - 1 - 7 - 8 - 5 - 3");

    }

    public static void numbersFromLastToFirst() {
        System.out.println("Пр.: Ако кажете 5 - 8, испитаникот треба да каже 8 - 5");
        System.out.println();
        System.out.println("Б. Броеви наназад: ");
        System.out.println();
        System.out.println("(2) 2 - 5");
        System.out.println("    6 - 3");
        System.out.println();
        System.out.println("(3) 5 - 7 - 4");
        System.out.println("    2 - 5 - 9");
        System.out.println();
        System.out.println("(4) 7 - 2 - 9 - 6");
        System.out.println("    8 - 4 - 1 - 3");
        System.out.println();
        System.out.println("(5) 4 - 9 - 6 - 2 - 7");
        System.out.println("    9 - 7 - 8 - 5 - 2");
        System.out.println();
        System.out.println("(6) 1 - 6 - 5 - 2 - 9 - 8");
        System.out.println("    3 - 6 - 7 - 1 - 9 - 4");
        System.out.println();
        System.out.println("(7) 8 - 5 - 9 - 2 - 3 - 7 - 2");
        System.out.println("    4 - 5 - 7 - 9 - 2 - 8 - 1");
        System.out.println();
        System.out.println("(8) 6 - 9 - 1 - 6 - 3 - 2 - 5 - 8");
        System.out.println("    3 - 1 - 7 - 9 - 5 - 4 - 8 - 2");

    }

    public static void addPointsForTestNumber1(int addPoints) {
        if (addPoints >= 0 && addPoints <= 9) {
            result1 = addPoints;
            System.out.println("Успешно беа додадени " + addPoints + " поени за А.Броеви нанапред");
        } else {
            System.out.println("Не можете да внесете помалку од 0 или повеќе од 9 поени");

        }
    }

    public static void addPointsForTestNo1() {
        try {
            System.out.println("Внесете поени за тестот А.Броеви нанапред: (0 - 9)");
            int points = scanner.nextInt();
            scanner.nextLine();
            addPointsForTestNumber1(points);
        } catch (InputMismatchException e) {
            System.out.println("Ве молиме внесете број");
            scanner.nextLine();
            addPointsForTestNo1();

        }
    }

    public static void addPointsForTestNumber2(int addPoints) {
        if (addPoints >= 0 && addPoints <= 8) {
            result2 = addPoints;
            System.out.println("Успешно беа додадени " + addPoints + " поени за Б.Броеви наназад");
        } else {
            System.out.println("Не можете да внесете помалку од 0 или повеќе од 8 поени");
        }
    }

    public static void addPointsForTestNo2() {
        try {
            System.out.println("Внесете поени за тестот Б.Броеви наназад: (0 - 8)");
            int points = scanner.nextInt();
            scanner.nextLine();
            addPointsForTestNumber2(points);
        } catch (InputMismatchException e) {
            System.out.println("Ве молиме внесете број");
            scanner.nextLine();
            addPointsForTestNo2();
        }
    }

    public static void printResult() {
        int sum = result1 + result2;
        System.out.println("А.Броеви нанапред = " + result1 + " поени; Б.Броеви наназад = " + result2 + " поени");
        System.out.println("Помнење (вкупно поени) = " + sum + "/17");
    }

    public static int getResult() {
        return result1 + result2;
    }

    public static void addPlusPointsForTestNo1(int points) {
        if ((result1 + points) <= 9 && points > 0) {
            result1 = result1 + points;
            System.out.println("Додадовте " + points + " поени");
            printResult();
        } else {
            System.out.println("Додавањето поени не беше успешно");
        }
    }

    public static void addPlusPointsForTestNo2(int points) {
        if ((result2 + points) <= 8 && points > 0) {
            result2 = result2 + points;
            System.out.println("Додадовте " + points + " поени");
            printResult();
        } else {
            System.out.println("Додавањето поени не беше успешно");
        }
    }

    public static void addPlusTestNo1() {
        try {
            System.out.println("Пишете го бројот на поени кои што сакате да бидат додадени на тестот А.Броеви нанапред: ");
            int points = scanner.nextInt();
            scanner.nextLine();
            addPlusPointsForTestNo1(points);
        } catch (InputMismatchException e) {
            System.out.println("Ве молиме внесете број");
            scanner.nextLine();
            addPlusTestNo1();
        }

    }

    public static void addPlusTestNo2() {
        try {
            System.out.println("Пишете го бројот на поени кои што сакате да бидат додадени на тестот Б.Броеви наназад: ");
            int points = scanner.nextInt();
            scanner.nextLine();
            addPlusPointsForTestNo2(points);
        } catch (InputMismatchException e) {
            System.out.println("Ве молиме внесете број");
            scanner.nextLine();
            addPlusTestNo2();
        }
    }

    public static void subtractionTestNo1(int points) {
        if ((result1 - points) >= 0 && points >= 0) {
            result1 = result1 - points;
            System.out.println("Одземавте " + points + " поени");
            printResult();
        } else {
            System.out.println("Неуспешен обид за одземање поени");
        }
    }

    public static void subtractionTestNo2(int points) {
        if ((result2 - points) >= 0 && points >= 0) {
            result2 = result2 - points;
            System.out.println("Одземавте " + points + " поени");
            printResult();
        } else {
            System.out.println("Неуспешен обид за одземање поени");
        }
    }

    public static void minusTestNo1() {
        try {
            System.out.println("Пишете го бројот на поени кои што сакате да бидат одземени од тестот А.Броеви нанапред");
            int points = scanner.nextInt();
            scanner.nextLine();
            subtractionTestNo1(points);
        } catch (InputMismatchException e) {
            System.out.println("Ве молиме внесете број");
            scanner.nextLine();
            minusTestNo1();
        }
    }

    public static void minusTestNo2() {
        try {
            System.out.println("Пишете го бројот на поени кои што сакате да бидат одземени од тестот Б.Броеви наназад");
            int points = scanner.nextInt();
            scanner.nextLine();
            subtractionTestNo2(points);
        } catch (InputMismatchException e) {
            System.out.println("Ве молиме внесете број");
            scanner.nextLine();
            minusTestNo2();
        }
    }

    public static void printOptions() {
        System.out.println("0 -  за излез");
        System.out.println("1 -  види опции");
        System.out.println("2 -  прочитај упатство");
        System.out.println("3 -  види броеви нанапред");
        System.out.println("4 -  запиши бодови за броеви нанапред");
        System.out.println("5 -  види броеви наназад");
        System.out.println("6 -  запиши бодови за броеви наназад");
        System.out.println("7 -  види резултат");
        System.out.println("8 -  додади поени на А.Броеви нанапред");
        System.out.println("9 -  додади поени на Б.Броеви наназад");
        System.out.println("10 - одземи поени од А.Броеви нанапред");
        System.out.println("11 - одземи поени од Б.Броеви наназад");
    }
}
