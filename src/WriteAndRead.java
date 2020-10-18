import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteAndRead {
    private String firstName;
    private String lastName;
    private int age;


    private static List<WriteAndRead> list = new ArrayList<>();

    public WriteAndRead(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    private static Scanner scanner;

    public static void main(String[] args) throws IOException {


//        WriteAndRead customer1 = new WriteAndRead("Monika", "Spaseva", 30);
//        WriteAndRead customer2 = new WriteAndRead("Spase", "Markovski", 32);

//        list.add(customer1);
//        list.add(customer2);


//        try (FileWriter fileWriter = new FileWriter("customers.txt")) {
//            for (WriteAndRead l : list) {
//
//                fileWriter.write(l.firstName + "," + l.lastName + "," + l.age + "\n");
//
//            }
//        }

        try (FileReader reader = new FileReader("customers.txt")) {
            Scanner scan = new Scanner(reader);
//            scan.useDelimiter(",");
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] words = line.split(",");
                String firstName = words[0];
                String lastName = words[1];
                int age = Integer.parseInt(words[2]);
                System.out.println(firstName + " " + lastName + " " + age);
                WriteAndRead writeAndRead = new WriteAndRead(firstName, lastName, age);
                list.add(writeAndRead);
            }

            scan.close();
        } catch (FileNotFoundException | NoSuchElementException e) {
            throw e;

        }
    }
}


