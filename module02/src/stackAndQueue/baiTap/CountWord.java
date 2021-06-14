package stackAndQueue.baiTap;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Map<String,Integer> treeMap =new TreeMap<>();
        System.out.println("Enter String ");
        String string = scanner.nextLine().trim();
        String[] string1= string.split(" ");
        int i=1;
        for(String w:string1){
            if(treeMap.containsKey(w)){
                treeMap.put(w,i);
                i++;
            }else {
                treeMap.put(w,1);
            }
        }
        System.out.println(treeMap);

    }
}
