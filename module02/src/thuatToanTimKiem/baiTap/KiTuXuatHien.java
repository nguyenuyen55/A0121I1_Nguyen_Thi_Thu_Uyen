package thuatToanTimKiem.baiTap;

import java.util.Scanner;

/*
 * in ra kí tự xuất hiện nhiều nhất trong một chuỗi
 * */
public class KiTuXuatHien {
    static int timKitu(char a, String string) {
        int dem = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == a) {
                dem++;
            }
        }
        return dem;
    }

    static void timKiTuXuatHien(String string) {
        int index = -1;
        int max = timKitu(string.charAt(0), string);
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (timKitu(string.charAt(i), string) < timKitu(string.charAt(j), string)) {
                    max = timKitu(string.charAt(j), string);
                    index = j;
                }
            }}
            System.out.println("kí tự "+string.charAt(index)+ " xuất hiện nhiều nhất ("+max+") lần");
        }
        public static void main (String[]args){
            Scanner scanner =new Scanner(System.in);
String string = scanner.nextLine();
timKiTuXuatHien(string);
        }
    }
    /*
    * độ phức tạp t(n)=o(n^3)
    * */
