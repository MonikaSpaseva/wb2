package wb2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFromFiles {

    private static Scanner scanner;


    private String testNo;
    private String subtestName;
    private int points;

    private static List<ReadFromFiles> list = new ArrayList<>();

    public ReadFromFiles(String testNo, String subtestName, int points) {
        this.testNo = testNo;
        this.subtestName = subtestName;
        this.points = points;
    }

    public static void main(String[] args) throws IOException {

        try (FileReader reader = new FileReader("basic_knowledge.txt")) {
            scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                String testNo = words[0];
                String testName = words[1];
                int points = Integer.parseInt(words[2]);
                System.out.println(testNo + " " + testName + " " + points);
                ReadFromFiles writeAndRead = new ReadFromFiles(testNo, testName, points);
                list.add(writeAndRead);
            }

            scanner.close();
        } catch (FileNotFoundException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        for (ReadFromFiles l : list) {
            System.out.println(l.testNo);
        }
    }
}