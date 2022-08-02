package ADVANCED.EXERCISE4_Streams_Files_And_Directories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P1_Sum_Lines {
    public static void main(String[] args) throws IOException {

        String path = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\EXERCISE4_Streams_Files_And_Directories\\Resources\\input";
        List<String> allLines = Files.readAllLines(Path.of(path));

        for (String line : allLines) {
            int sum = 0;
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                sum += currentSymbol;
            }
            System.out.println(sum);
        }
    }
}
