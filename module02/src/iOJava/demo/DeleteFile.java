package iOJava.demo;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
    File myObj =new File("filename.txt");
    if(myObj.delete()){
        System.out.println("deleted the file : "+myObj);
    }else {
        System.out.println("Failed to delete the file.");
    }
}
}
