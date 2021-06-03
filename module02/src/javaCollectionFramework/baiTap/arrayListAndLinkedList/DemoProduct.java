package javaCollectionFramework.baiTap.arrayListAndLinkedList;

import java.util.Scanner;

public class DemoProduct {
    public static void menu() {
        System.out.println("========MENU PRODUCT============");
        System.out.println("1. Add Product.");
        System.out.println("2. Update Product.");
        System.out.println("3. Delete Product");
        System.out.println("4. Display list product.");
        System.out.println("5. Search Name Product. ");
        System.out.println("6. Sort products in ascending order.");
        System.out.println("7. Sort products in descending order . ");
        System.out.println("8. Exit. ");
        System.out.println("Enter my choice : ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

        int choice = 0;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter count product need add : ");
                    int count=scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        productManager.addProduct();
                    }
                    break;
                case 2:
                    productManager.display();
                    productManager.updateProduct();
                    break;
                case 3:
                    productManager.display();
                    productManager.deleteProduct();
                    break;
                case 4:
                    productManager.display();
                    break;
                case 5:
                    productManager.searchProduct();
                    break;
                case 6:
                    productManager.sortProductASC();
                    break;
                case 7:
                    productManager.sortProductDescending();
                    break;
            }
            if (choice == 8) {
                System.out.println("Exit programming");
                break;
            }

        } while (choice < 8 && choice > 0);
    }
}
