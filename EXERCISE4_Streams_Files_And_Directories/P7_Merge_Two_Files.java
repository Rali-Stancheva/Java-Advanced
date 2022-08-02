package ADVANCED.EXERCISE4_Streams_Files_And_Directories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P7_Merge_Two_Files {
    public static void main(String[] args) throws IOException {

        String pathOne = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\EXERCISE4_Streams_Files_And_Directories\\Resources\\inputOne";
        String pathTwo = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\EXERCISE4_Streams_Files_And_Directories\\Resources\\inputTwo";

        PrintWriter writer = new PrintWriter("result_7");

        List<String> listOne = Files.readAllLines(Path.of(pathOne));
        listOne.forEach(line -> writer.println(line));
        List<String> listTwo = Files.readAllLines(Path.of(pathTwo));
        listTwo.forEach(line -> writer.println(line));

        writer.close();
    }
}
