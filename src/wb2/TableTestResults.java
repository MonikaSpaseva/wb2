package wb2;
import wb2.basic_knowledge_subtestNo1.ManageQAndATestNo1;
import wb2.calculations_subtestNo4.ManageSubtestNo4;
import wb2.commonterms_subtestNo5.MainTestNo5;
import wb2.memory_subtestNo3.MainSubtestNo3;
import wb2.thinking_subtestNo2.ManageSubtestNo2;
import wb2.whatsmissing_subtestNo7.ManageTestNo7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TableTestResults {
    private static Scanner scanner = new Scanner(System.in);


    private Connection connection;

    public TableTestResults(Connection connection) {
        this.connection = connection;
    }


    public void addResultTestNo1(ManageQAndATestNo1 manageQAndATestNo1) {

        System.out.println("Внесете го персоналниот број на испитаникот");
        String pn = scanner.nextLine();

        int points1 = manageQAndATestNo1.pointsForTestNo1();

        try (Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO tests (client_pn, test_name, test_points)" +
                    "VALUES( '" + pn + "', 'Поученост'," + points1 + ")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////

    public void addResultTestNo2(ManageSubtestNo2 manageSubtestNo2) {
        System.out.println("Внесете го персоналниот број на испитаникот");
        String pn = scanner.nextLine();

        int points2 = manageSubtestNo2.getPoints();

        try(Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO tests (client_pn, test_name, test_points)" +
                    "VALUES( '" + pn + "', 'Сфаќање'," + points2 + ")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
///////////////????????
    public void addResultTestNo3() {
        System.out.println("Внесете го персоналниот број на испитаникот");
        String pn = scanner.nextLine();
        int result3 = MainSubtestNo3.getResult();

        try (Statement statement = connection.createStatement()){
            statement.execute("INSERT INTO tests (client_pn, test_name, test_points)" +
                    "VALUES( '" + pn + "', 'Помнење'," + result3 + ")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addResultTestNo4(ManageSubtestNo4 manageSubtestNo4) {
        System.out.println("Внесете го персоналниот број на испитаникот");
        String pn = scanner.nextLine();

        int result4 = manageSubtestNo4.getPoints();
        try (Statement statement = connection.createStatement()){
            statement.execute("INSERT INTO tests (client_pn, test_name, test_points)" +
                    "VALUES( '" + pn + "', 'Сметање'," + result4 + ")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
///////////////////////?????
    public void addResultTestNo5() {
        System.out.println("Внесете го персоналниот број на испитаникот");
        String pn = scanner.nextLine();
        int result5 = MainTestNo5.getPoints();
        try (Statement statement = connection.createStatement()){
            statement.execute("INSERT INTO tests (client_pn, test_name, test_points)" +
                    "VALUES( '" + pn + "', 'Заеднички поими'," + result5 + ")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addResultTestNo7(ManageTestNo7 manageTestNo7) {
        System.out.println("Внесете го персоналниот број на испитаникот");
        String pn = scanner.nextLine();


        int result7 = manageTestNo7.getPointsForTestNo7();
        try (Statement statement = connection.createStatement()){
            statement.execute("INSERT INTO tests (client_pn, test_name, test_points)" +
                    "VALUES( '" + pn + "', 'Дополнување слики'," + result7 + ")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
