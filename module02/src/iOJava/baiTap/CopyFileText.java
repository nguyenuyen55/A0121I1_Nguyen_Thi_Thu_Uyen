package iOJava.baiTap;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        //doc file
        readFile();
        writeFile();
        readFile();
//ghi file

    }
    static void writeFile(){
        try {
            FileWriter file = new FileWriter("filename.txt",true);
            BufferedWriter bufferedWriter =new BufferedWriter(file);
            bufferedWriter.write("\nhello anh dep trai ");
            bufferedWriter.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void readFile(){
        try {
            FileReader file = new FileReader("filename.txt");
            BufferedReader bufferedReader = new BufferedReader(file);
            String string = null;
            while ((string = bufferedReader.readLine())!=null){
                System.out.println(string);
            }
            bufferedReader.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
