package menu;


import manager.ProductManager;
import samples.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class FunctionDiplay {

    ProductManager manager = new ProductManager();
    Scanner inputString = new Scanner(System.in);
    Scanner inputNumber = new Scanner(System.in);
    public void handleFunction () {
        dataBase();
        showChoice();
        int choice = inputNumber.nextInt();
        do {
            switch (choice) {
                case 1:
                    functionAdd();
                    break;
                case 2:
                    functionEdit();
                    break;
                case 3:
                    functionDelete();
                    break;
                case 4:
                    disPlayAll();
                    break;
                case 5:
                    functionSearchByCode();
                    break;
                case 6:
                    functionSearchByName();
                    break;
                case 7:
                    functionFindPrice();
                    break;
                case 8:
                    functionFindCharacter();
                    break;
                case 9:
                    functionTotalByType();
                    break;
                case 10:
                    functionTotalByALlPrice();
                    break;
            }
            showChoice();
            choice = inputNumber.nextInt();

        }while (choice != 0);


    }
    public void showChoice () {
        System.out.println("-----Function------");
        System.out.println("1. Add Product ");
        System.out.println("2. Edit Product ");
        System.out.println("3. Delete Product ");
        System.out.println("4. Display All Product ");
        System.out.println("5. Search By Product code ");
        System.out.println("6. Search By product name");
        System.out.println("7. Search By product pice ");
        System.out.println("8. Search By product characters");
        System.out.println("9. Total By Type");
        System.out.println("10. Total price of all");
        System.out.println("0. Exit");
        System.out.println();
        System.out.println("Enter your choice");

    }
    public void disPlayAll() {
        System.out.println("-----ALL------");
        for (Product product : manager.getAll()) {
            System.out.println(product);
        }
    }
    public void functionAdd () {
        System.out.println("Enter product name");
        String name = inputString.nextLine();
        System.out.println("Enter product code");
        int code = inputNumber.nextInt();
        System.out.println("Enter product quantity");
        int quantity = inputNumber.nextInt();
        System.out.println("Enter product price");
        double price = inputNumber.nextDouble();
        System.out.println("Enter product type");
        String type = inputString.nextLine();
        Product product = new Product(name, price,type, quantity , code);
        manager.add(product);
        System.out.println("---- Added product successfully");
    }
    public void functionEdit () {
        System.out.println("Enter CODE to edit ");
        int index  ;
        do {
            int code = inputNumber.nextInt();
            index = manager.findIndexByCode(code) ;
            if (index != -1) {
                System.out.println("Enter product new name");
                String name = inputString.nextLine();
                System.out.println("Enter product new price");
                double price = inputNumber.nextDouble();
                System.out.println("Enter product new type");
                String type = inputString.nextLine();
                System.out.println("Enter product new quantity");
                int quantity = inputNumber.nextInt();
                Product newProduct = new Product(name, price,type, quantity , code);
                manager.edit(code , newProduct );
                System.out.println("---- Edited product successfully");
            }else {
                System.out.println("Code does not exist, please re-enter the code!");
            }
        }while (index == -1) ;


    }
    public void functionDelete () {
        System.out.println("Enter CODE to delete ");
        int code = inputString.nextInt();
        int index = manager.findIndexByCode(code) ;
        do {
            if (index != -1) {
                manager.remove(code);
                System.out.println("---- Removed product successfully");
            }else {
                System.out.println("Code does not exist, please re-enter the code!");
                code = inputString.nextInt();
            }
            index = manager.findIndexByCode(code) ;

        }while (index == -1) ;
        manager.remove(code);
        System.out.println("---- Removed product successfully");

    }
    public void functionSearchByCode () {
        System.out.println("Enter CODE to search");
        int index ;
        do {
            int code = inputNumber.nextInt();
            index = manager.findIndexByCode(code) ;
            if (index != -1) {
                System.out.println(manager.getAll().get(index));
            }else {
                System.out.println("Code does not exist, please re-enter the code!");
            }

        }while (index == -1) ;

    }
    public void functionSearchByName () {
        System.out.println("Enter NAME to search");
        String name ;
        int index ;
        do {
            name = inputString.nextLine();
            index = manager.findIndexByName(name) ;
            if (index != -1) {
                    System.out.println(manager.getAll().get(index));
            }else {
                System.out.println("Code does not exist, please re-enter the name!");
            }
        }while (index == -1) ;

    }
    public void functionFindPrice () {
        System.out.println("Enter minimum price");
        double priceMin = inputNumber.nextDouble();
        System.out.println("Enter maximum price");
        double priceMax = inputNumber.nextDouble();
        ArrayList<Product> newArr = new ArrayList<>() ;
        System.out.println("---The product you are looking for is : ");
       newArr = manager.findProductByPrice(priceMin,priceMax) ;
       for (Product product : newArr) {
           System.out.println(product);
       }
    }
    public void functionFindCharacter () {
        System.out.println("Enter the character you want to search for : ");
        String cha = inputString.nextLine();
        ArrayList<Product> newArr = new ArrayList<>() ;
        newArr = manager.findProductByCharacter(cha);
        for (Product product : newArr) {
            System.out.println(product);
        }
    }
    public void functionTotalByType () {
        System.out.println("type 1 : No Sugar");
        System.out.println("type 2 : Have Sugar");
        System.out.println("type 3 : Less Sugar");
        System.out.println("Select the type to calculate : ");
        int type = inputNumber.nextInt();
        switch (type) {
            case 1:

                System.out.println("Total product equals : ");
                int type1  = manager.totalByType("No Sugar");
                System.out.println(type1);
                break;
            case 2:
                System.out.println("Total product equals : ");
                int type2  = manager.totalByType("Have Sugar");
                System.out.println(type2);
                break;
            case 3:
                System.out.println("Total product equals : ");
                int type3 = manager.totalByType("Less Sugar");
                System.out.println(type3);
                break;
        }

    }
    public void functionTotalByALlPrice () {
        System.out.println("Total all product equals : ");
        double totalPrice = manager.totalByPrice();
        System.out.println(totalPrice);

    }

   public void dataBase () {
       Product sp1 = new Product("Vinamilk", 23000 , "No Sugar" , 5, 111) ;
       Product sp2 = new Product("TH Truemilk", 25000 , "No Sugar" , 5, 222) ;
       Product sp3 = new Product("Vinasoy", 28000 , "Have Sugar" , 6, 333) ;
       Product sp4 = new Product("Nutifood", 18000 , "Less Sugar" , 7,444) ;
       Product sp5 = new Product("Vinamilk" , 24000 , "Less Sugar" , 10, 111) ;

       manager.add(sp1);
       manager.add(sp2);
       manager.add(sp3);
       manager.add(sp4);
       manager.add(sp5);

   }
}
