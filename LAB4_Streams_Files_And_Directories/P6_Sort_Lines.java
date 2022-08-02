package ADVANCED.LAB4_Streams_Files_And_Directories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P6_Sort_Lines {
    public static void main(String[] args) throws IOException {

        String pathIn = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\input";
        String pathOut = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\06.SortLinesOutput";

        Path input = Paths.get(pathIn);
        Path output = Paths.get(pathOut);

        List<String> list = Files.readAllLines(input);
        Collections.sort(list);
        Files.write(output,list);
    }
}
