import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PersonReader {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Person Files", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (Scanner fileScanner = new Scanner(selectedFile)) {
                System.out.println("Displaying records from: " + selectedFile.getName());
                System.out.println();

                displayHeader();
                System.out.println("=================================================================");

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    displayFormattedRecord(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + selectedFile.getName());
            }
        }
    }

    public static void displayHeader() {
        System.out.printf("%-10s%-15s%-15s%-12s%-15s\n", "ID", "First Name", "Last Name", "Title", "YOB");
    }

    public static void displayFormattedRecord(String record) {
        String[] data = record.split(", ");
        if (data.length == 5) {
            System.out.printf("%-10s%-15s%-15s%-12s%-15s\n", data[0], data[1], data[2], data[3], data[4]);
        } else {
            System.out.println("Invalid record format: " + record);
        }
    }
}