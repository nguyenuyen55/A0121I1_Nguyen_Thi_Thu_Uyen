package iOJava.baiTap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static void main(String[] args) {
 List<Country> countries =readData();
        for (Country country: countries) {
            System.out.println(country.toString());
        }


    }
    public static List<Country> readData(){
        List<Country> countries =new ArrayList<>();
        FileReader myObj = null;
        try {
            myObj = new FileReader("listCountry.csv");
            BufferedReader bufferedReader = new BufferedReader(myObj);
            String line =null;
            while((line=bufferedReader.readLine())!=null){
                Country country =new Country();
                String data[] = line.split(",");
                country.setStartIp(data[0]);
                country.setEndIp(data[1]);
                country.setCountryCode(data[2]);
                country.setCountry(data[3]);
                countries.add(country);
            }
            bufferedReader.close();
            myObj.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
