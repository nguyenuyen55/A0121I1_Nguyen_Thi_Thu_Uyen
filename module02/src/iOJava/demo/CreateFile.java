package iOJava.demo;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        File myObj= new File("filename.txt");
        try {
            if(myObj.createNewFile()){
                System.out.println("File create : "+myObj.getName());
            }else {
                System.out.println("File already exists. ");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
