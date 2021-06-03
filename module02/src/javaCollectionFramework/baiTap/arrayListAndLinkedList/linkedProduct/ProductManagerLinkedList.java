package javaCollectionFramework.baiTap.arrayListAndLinkedList.linkedProduct;

import javaCollectionFramework.baiTap.arrayListAndLinkedList.PriceDescending;
import javaCollectionFramework.baiTap.arrayListAndLinkedList.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManagerLinkedList {
    Scanner scanner = new Scanner(System.in);
    LinkedList<Product> linkedList = new LinkedList<>();

    public void addProduct() {

        int id = 0;
        System.out.println("Enter id: ");
        boolean check;
        int dem = 0;
        do{
            check=true;
            id = scanner.nextInt();
            for (Product product : linkedList) {
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
        linkedList.add(new Product(id,name,price));

    }

    public void updateProduct() {

        if(linkedList.size()==0){
            System.out.println("List Null , add product before you want update please");
        }else {
            System.out.println("Enter id Update");
            int id = scanner.nextInt();
            int dem = 0;
            for (Product product : linkedList) {
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
        if(linkedList.size()==0){
            System.out.println("List Null , add product before you want delete please");
        }else {
            System.out.println("Enter id products you want delete");
            int id = scanner.nextInt();
            int dem = 0;
            for (Product product : linkedList) {
                if (product.getId() == id) {
                    dem++;
                    linkedList.remove(product);
                    System.out.println("Delete success");
                    break;
                }
            }
            if (dem == 0) {
                System.out.println("id not exist");
            }
        }}

    public void display() {
        if(linkedList.size()==0){
            System.out.println("List Null , add product before you want display list products");
        }else {
            for (Product product : linkedList) {
                System.out.println(product.toString());
            }}
    }

    public void searchProduct() {
        System.out.println("Enter Name Product search ");
        String name = scanner.nextLine();
        int dem = 0;
        String result = "";
        for (Product product : linkedList) {
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
        Collections.sort(linkedList);
    }
    public void sortProductDescending() {
        PriceDescending priceDescending=new PriceDescending();
        Collections.sort(linkedList,priceDescending);
    }
}
