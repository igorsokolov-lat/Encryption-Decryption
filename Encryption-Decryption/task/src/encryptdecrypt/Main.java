package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String operation = "enc";
        int key = 0;
        StringBuilder message = new StringBuilder("");
        String filePath;
        String outputFilePath = "";
        String dataArg = "";
        String outputArg = "";
        String algorithm = "shift";

        ReadFromFile read = new ReadFromFile();
        WriteToFile write = new WriteToFile();
        Encryptor encryptor = new Encryptor();
        Decryptor decryptor = new Decryptor();

        for (int i = 0; i < args.length; i += 2) {
            if ("-mode".equals(args[i])) {
                operation = args[i + 1];
            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-data".equals(args[i])) {
                dataArg = args[i];
                message = new StringBuilder(args[i + 1]);
            } else if ("-in".equals(args[i])) {
                if (!"-data".equals(dataArg)) {
                    filePath = args[i + 1];
                    message = read.readInputFile(filePath, message);
                }
            } else if ("-out".equals(args[i])) {
                outputArg = args[i];
                outputFilePath = args[i + 1];
            } else if ("-alg".equals(args[i])) {
                algorithm = args[i + 1];
            }
        }

        switch (operation) {
            case ("enc"):
                if ("unicode".equals(algorithm)) {
                    encryptor.setMethod(new UnicodeEncryptionMethod());
                } else {
                    encryptor.setMethod(new ShiftEncryptionMethod());
                }
                message = encryptor.encrypt(key, message);
                if ("".equals(outputArg)) {
                    System.out.println(message);
                } else {
                    write.writeDataToFile(outputFilePath, message);
                }
                break;
            case ("dec"):
                if ("unicode".equals(algorithm)) {
                    decryptor.setMethod(new UnicodeDecryptionMethod());
                } else {
                    decryptor.setMethod(new ShiftDecryptionMethod());
                }
                message = decryptor.decrypt(key, message);
                if ("".equals(outputArg)) {
                    System.out.println(message);
                } else {
                    write.writeDataToFile(outputFilePath, message);
                }
                break;
            default:
                break;
        }
    }
}
