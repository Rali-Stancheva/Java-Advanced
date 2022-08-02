package ADVANCED.LAB4_Streams_Files_And_Directories;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class P5_Write_Every_Third_Line {
    public static void main(String[] args) throws IOException {

        String pathIn = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\input";
        String pathOut = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\05.WriteEveryThirdLineOutput";

        Scanner in = new Scanner(new FileReader(pathIn));
        PrintWriter out = new PrintWriter(new FileWriter(pathOut));

        int counter = 1;
        String line = in.nextLine();
        while (in.hasNextLine()) {
            if (counter % 3 == 0) {
                out.println(line);
            }
            counter++;
            line = in.nextLine();
            out.flush();
        }
        out.close();
        in.close();
    }
}
