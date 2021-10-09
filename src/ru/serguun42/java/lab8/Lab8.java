package ru.serguun42.java.lab8;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab8 {
    public static void main(String[] args) {
        try {
            Path inputFilePath = Paths.get(System.getProperty("user.dir"), "src/ru/serguun42/java", "lab8", "lorem-input.txt");
            String loremFancySize = readFromFileReader(new FileReader(inputFilePath.toString()));

            System.out.println("Here comes SIT AMET:");
            System.out.println(loremFancySize);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static String readFromFileReader(FileReader fileReader)
        throws IOException {
            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;

                while ((line = bufferedReader.readLine()) != null)
                    resultStringBuilder.append(line).append("\n");
        }

        return resultStringBuilder.toString();
    }
}
