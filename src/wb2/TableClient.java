package wb2;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TableClient {
    private static Scanner scanner = new Scanner(System.in);
    private static Person person = new Person();
    private static Statement statement = null;


    public static void main(String[] args) {

        printOptions();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User1\\Desktop\\wb.db");
            statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS clients (id INTEGER PRIMARY KEY, firstname_lastname TEXT NOT NULL, age INTEGER, date_of_exam TEXT, personal_number TEXT NOT NULL UNIQUE)");
            statement.execute("CREATE TABLE IF NOT EXISTS tests (id INTEGER PRIMARY KEY, client_pn TEXT, test_name TEXT, test_points INTEGER)");

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
                        addClient();
                        add();
                        break;
                    case "3":
                        delete();
                        break;
                    case "4":
                        update();
                        break;
                    case "5":
                        printListOfClients();
                        break;
                }
            }

            statement.close();
            connection.close();
            scanner.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void addClient() {
        System.out.println("Име и презиме на испитаникот: ");
        String nameLastName = scanner.nextLine();
        person.setFirstNameAndLastName(nameLastName);

        System.out.println("Возраст на испитаникот: ");
        String age = scanner.nextLine();
        try {
            person.setAge(Integer.parseInt(age));
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Дата на испитување: ");
        String date = scanner.nextLine();
        person.setDate(date);

        System.out.println("Број на лична карта на испитаникот");
        String id = scanner.nextLine();
        person.setPersonalNumber(id);
    }


    public static void add() {
        try {
            statement.execute("INSERT INTO clients ( firstname_lastName, age, date_of_exam,  personal_number)" +
                    "VALUES (" + "'" + person.getFirstNameAndLastName() + "'" + ", " + person.getAge() + "," + "'" + person.getDate() + "'" + "," + "'" + person.getPersonalNumber() + "'" + ")");
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void delete() {
        System.out.println("Број на лична карта: ");
        String pn = scanner.nextLine();
        try {
            statement.execute("DELETE FROM clients WHERE personal_number = '" + pn + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update() {
        System.out.println("Број на лична карта");
        String pn = scanner.nextLine();
        System.out.println("Име и презиме на клиентот: ");
        String firstLast = scanner.nextLine();
        person.setFirstNameAndLastName(firstLast);
        System.out.println("Возраст на испитаникот: ");
        String age = scanner.nextLine();
        try {
            person.setAge(Integer.parseInt(age));
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Дата на испитување: ");
        String date = scanner.nextLine();
        person.setDate(date);

        System.out.println("Број на лична карта на испитаникот");
        String id = scanner.nextLine();
        person.setPersonalNumber(id);


        try {
            statement.execute("UPDATE clients SET firstname_lastName = '"
                    + person.getFirstNameAndLastName() + "', age = " + person.getAge() + ", date_of_exam = '"
                    + person.getDate() + "', personal_number = '" + person.getPersonalNumber()
                    + "' WHERE personal_number = '" + pn + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printListOfClients() {
        try {
            ResultSet results = statement.executeQuery("SELECT * FROM clients");
            while (results.next()) {
                System.out.println(results.getInt("id") + ". " + results.getString("firstname_lastname") + " " +
                        results.getInt("age") + " " +
                        results.getString("date_of_exam") + " " +
                        results.getString("personal_number"));
            }

            results.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printOptions() {
        System.out.println("0 - исклучи");
        System.out.println("1 - види опции");
        System.out.println("2 - додади нов клиент");
        System.out.println("3 - избриши постоечки клиент");
        System.out.println("4 - измени податоци за клиент");
        System.out.println("5 - испринтај листа со клиенти");
    }

}
