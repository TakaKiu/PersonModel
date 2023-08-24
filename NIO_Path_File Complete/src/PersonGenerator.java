import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        ArrayList<String> personRecords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter Title");
            int YOB = SafeInput.getRangedInt(scanner, "Enter Year of Birth", 0, 2023);

            String personData = id + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
            personRecords.add(personData);

            boolean continueInput = SafeInput.getYNConfirm(scanner, "Do you want to add another person? (Y/N)");
            if (!continueInput) {
                break;
            }
        }

        String fileName = "PersonTestData.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String record : personRecords) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the records.");
            e.printStackTrace();
        }

        scanner.close();
    }
}