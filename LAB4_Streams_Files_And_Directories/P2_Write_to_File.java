package ADVANCED.LAB4_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class P2_Write_to_File {
    public static void main(String[] args) throws IOException {

        String pathIn = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\input";
        String pathOut = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\02.WriteToFileOutput";

        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '.', ',', '!', '?');

        FileInputStream in = new FileInputStream(pathIn);
        FileOutputStream out = new FileOutputStream(pathOut);

        int oneByte = in.read();
        while (oneByte >= 0){
            char myByteAsChar =(char)oneByte;
            if (!punctuation.contains(myByteAsChar)){
                out.write(oneByte);
            }
            oneByte = in.read();
        }
    }
}
