package ADVANCED.EXERCISE4_Streams_Files_And_Directories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P3_ALL_CAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\EXERCISE4_Streams_Files_And_Directories\\Resources\\input";
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

        List<String> line = Files.readAllLines(Path.of(path));
        for (String s : line) {
            bw.write(s.toUpperCase());
            bw.newLine();
        }
        bw.close();
    }
}
