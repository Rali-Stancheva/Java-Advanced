package ADVANCED.EXERCISE4_Streams_Files_And_Directories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P2_Sum_Bytes {
    public static void main(String[] args) throws IOException {

        String path = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\EXERCISE4_Streams_Files_And_Directories\\Resources\\input";
        long sum = 0; //сумата от всички символи във файла
        //начин 1
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        //спираме: line == null
        while (line != null) {
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                sum += currentSymbol;
            }
            line = br.readLine();
        }
        System.out.println(sum);
    }
}


