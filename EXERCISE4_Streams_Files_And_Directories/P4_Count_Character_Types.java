package ADVANCED.EXERCISE4_Streams_Files_And_Directories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P4_Count_Character_Types {
    public static void main(String[] args) throws IOException {
        String path = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\EXERCISE4_Streams_Files_And_Directories\\Resources\\input";
        List<String> line = Files.readAllLines(Path.of(path));

        int vowelsCount = 0;  //гласни
        int consonantsCount = 0;  //съгласни
        int punctuationCount = 0; //пунктуация

        for (String elements : line) {
            for (int i = 0; i < elements.length(); i++) {
                char currSymbol = elements.charAt(i);
                if (currSymbol == ' ') {
                    continue;
                }

                if (currSymbol == 'a' || currSymbol == 'e' || currSymbol == 'i' || currSymbol == 'o' || currSymbol == 'u') {
                    vowelsCount++;
                } else if (currSymbol == '!' || currSymbol == ',' || currSymbol == '.' || currSymbol == '?') {
                    punctuationCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("output_task_4"));
        bw.write("Vowels: " + vowelsCount);
        bw.newLine();
        bw.write("Consonants: " + consonantsCount);
        bw.newLine();
        bw.write("Punctuation: " + punctuationCount);
        bw.close();
    }
}
