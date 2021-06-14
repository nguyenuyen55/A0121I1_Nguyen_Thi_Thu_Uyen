package javaCollectionFramework.baiTap.arrayListAndLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    List<Product> arrayList = new ArrayList<>();

    public void addProduct() {

        int id = 0;
        System.out.println("Enter id: ");
        boolean check;
        int dem = 0;
        do{
            check=true;
            id = scanner.nextInt();
            for (Product product : arrayList) {
                if (product.getId() == id) {
                    check=false;
                    System.out.println("Id exist enter id again : ");
                    break;
                }
            }

        }while (!check);


        System.out.println("Enter name : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter price : ");
        int price = scanner.nextInt();
        arrayList.add(new Product(id,name,price));

    }

    public void updateProduct() {

        if(arrayList.size()==0){
            System.out.println("List Null , add product before you want update please");
        }else {
        System.out.println("Enter id Update");
        int id = scanner.nextInt();
        int dem = 0;
        for (Product product : arrayList) {
            if (product.getId() == id) {
                dem++;
                System.out.println("Enter name ");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Enter price ");
                int price = scanner.nextInt();
                product.setName(name);
                product.setPrice(price);
                System.out.println("Update success");
                break;
            }
        }
        if (dem == 0) {
            System.out.println("id not have");
        }}
    }

    public void deleteProduct() {
        if(arrayList.size()==0){
            System.out.println("List Null , add product before you want delete please");
        }else {
        System.out.println("Enter id products you want delete");
        int id = scanner.nextInt();
        int dem = 0;
        for (Product product : arrayList) {
            if (product.getId() == id) {
                dem++;
                arrayList.remove(product);
                System.out.println("Delete success");
                break;
            }
        }
        if (dem == 0) {
            System.out.println("id not exist");
        }
    }}

    public void display() {
        if(arrayList.size()==0){
            System.out.println("List Null , add product before you want display list products");
        }else {
        for (Product product : arrayList) {
            System.out.println(product.toString());
        }}
    }

    public void searchProduct() {
        //tìm kiếm gần đúng
        System.out.println("Enter Name Product search ");
        String name = scanner.nextLine();
        int dem = 0;
        String result = "";
        for (Product product : arrayList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                dem++;
                result += product.toString() + "\n";
            }
        }
        if (dem == 0) {
            System.out.println("not result like word search");
        } else {
            System.out.println("have " + dem + " result : ");
            System.out.println(result);
        }

    }

    public void sortProductASC() {
        Collections.sort(arrayList);
    }
    public void sortProductDescending() {
       PriceDescending priceDescending=new PriceDescending();
       Collections.sort(arrayList,priceDescending);
    }
}
