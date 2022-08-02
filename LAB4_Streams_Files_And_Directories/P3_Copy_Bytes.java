package ADVANCED.LAB4_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P3_Copy_Bytes {
    public static void main(String[] args) throws IOException {

        String pathIn= "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\input";
        String pathOut = "D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\03.CopyBytesOutput";

        FileInputStream in = new FileInputStream(pathIn);
        FileOutputStream out = new FileOutputStream(pathOut);

        int oneByte = in.read();
        while (oneByte >= 0){
            if (oneByte == 32 || oneByte == 10) {
                out.write(oneByte);
            }else {
                String digit = String.valueOf(oneByte);
                for (int i = 0; i < digit.length(); i++) {
                    out.write(digit.charAt(i));
                }
            }
            oneByte = in.read();
        }
    }
}
