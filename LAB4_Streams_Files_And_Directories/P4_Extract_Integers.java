package ADVANCED.LAB4_Streams_Files_And_Directories;

import java.io.*;
import java.util.Scanner;

public class P4_Extract_Integers {
    public static void main(String[] args) throws IOException {

        String pathIn = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\input";
        String pathOut = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\04.ExtractIntegersOutput";

        Scanner scan = new Scanner(new FileInputStream(pathIn));
        FileOutputStream out = new FileOutputStream(pathOut);
        PrintWriter myFileOutput = new PrintWriter(out);

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int myNumber = scan.nextInt();
                myFileOutput.println(myNumber);
            }
            scan.next();
        }
        myFileOutput.close();
    }
}
