package iOJava.demo;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt",true);

            myWriter.write("Files in Java might be tricky, but it is fun enough !\n");

            myWriter.write("uyen is crazy");
            myWriter.close();
            System.out.println("Successfully wrote to the file. ");
        } catch (IOException e) {
            System.out.println("an error occurred. ");
            e.printStackTrace();
        }
    }
}
