package iOJava.thucHanh;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumInteger {
    public static void main(String[] args) {
        FileReader  fileReader;

        {
            try {
                fileReader = new FileReader("number.txt");
                BufferedReader bufferedReader =new BufferedReader(fileReader);
               String line =null;
                int sum=0;
                while ((line = bufferedReader.readLine())!=null){
                    System.out.print(line+" ");
                    sum+=Integer.parseInt(line);
                }
                System.out.println("tong :"+sum);
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
