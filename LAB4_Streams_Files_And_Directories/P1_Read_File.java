package ADVANCED.LAB4_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.IOException;

public class P1_Read_File {
    public static void main(String[] args) {
        String path = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\input";

        try (FileInputStream file = new FileInputStream(path)) {
            int oneByte = file.read();  //прочитаме файла по един байт
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = file.read();   //четем нов ред
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
