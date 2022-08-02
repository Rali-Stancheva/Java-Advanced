package ADVANCED.EXERCISE4_Streams_Files_And_Directories;

import java.io.File;

public class P8_Get_Folder_Size {
    public static void main(String[] args) {

        String path = "C:\\Users\\User\\Desktop\\softUni_ADVANCED\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        File folder = new File(path);
        File[] allFiles = folder.listFiles();

        int folderSize = 0;
        for (File file : allFiles) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
