package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {

    public static StringBuilder readInputFile(String filePath, StringBuilder message) {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                message = new StringBuilder(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error. File not found.");
        }
        return message;
    }
}
