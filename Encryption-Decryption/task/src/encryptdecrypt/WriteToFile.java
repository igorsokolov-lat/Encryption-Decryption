package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void writeDataToFile(String outputFilePath, StringBuilder message) {
        File file = new File(outputFilePath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.valueOf(message));
        } catch (IOException e) {
            System.out.println("Error. Cannot write file.");
        }
    }
}
