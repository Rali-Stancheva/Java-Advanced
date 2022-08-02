package ADVANCED.EXERCISE4_Streams_Files_And_Directories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P6_Word_Count {
    public static void main(String[] args) throws IOException {
        String pathWords = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\EXERCISE4_Streams_Files_And_Directories\\Resources\\words";
        Map<String, Integer> countWords = new HashMap<>();

        List<String> lineWords = Files.readAllLines(Path.of(pathWords));
        for (String element : lineWords) {
            Arrays.stream(element.split("\\s+")).forEach(word -> {
                countWords.put(word, 0);
            });
        }

        String path = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\EXERCISE4_Streams_Files_And_Directories\\Resources\\text";
        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                if (countWords.containsKey(word)) {
                    int currentWord = countWords.get(word);
                    countWords.put(word, currentWord + 1);
                }
            });
        }
        PrintWriter writer = new PrintWriter("results.txt");
        countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
