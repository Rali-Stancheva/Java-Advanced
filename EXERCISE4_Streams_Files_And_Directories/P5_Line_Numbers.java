package ADVANCED.EXERCISE4_Streams_Files_And_Directories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P5_Line_Numbers {
    public static void main(String[] args) throws IOException {

        String path = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\EXERCISE4_Streams_Files_And_Directories\\Resources\\inputLineNumbers";
        List<String> line = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("output_problem_5");
        int number = 1;
        for (String s : line) {
            writer.println(number + ". " + s);
            number++;
        }
        writer.close();
    }
}
