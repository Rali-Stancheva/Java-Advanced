package ADVANCED.LAB4_Streams_Files_And_Directories;

import java.io.File;

public class P7_List_Files {
    public static void main(String[] args) {
        File file = new File("D:\\за училище\\NOVA PAPKA\\ConcatenateData\\src\\ADVANCED\\LAB4_Streams_Files_And_Directories\\Resources\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]\n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}

