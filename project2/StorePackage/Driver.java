package StorePackage;

import java.util.*;
import java.io.*;

/**
* Driver class
* @author Cody Blakeney
*/
public class Driver{

        /**
        * run flag for menu loop
        */
        public static boolean run = true;

        /**
        * main function
        * @param args command line arguments
        */
        public static void main(String[] args){
                Inventory inventory = new Inventory();
                Scanner sc = new Scanner(System.in);

                try {
                    FileInputStream fis = new FileInputStream("movieInventory");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    inventory = (Inventory)ois.readObject(); // explicit cast reqd
                    fis.close();
                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                    System.out.println("Problem with file input.");
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found on input from file.");
                }
                     
                while(Driver.run){
                        displayMenu();
                        getInput(inventory, sc);
                }
        }

        /**
        * prints menu to for user to make decision
        */
        public static void displayMenu(){
                System.out.println("\nVideo Store Inventory Menu\n");
                System.out.println("1. Add Product");
                System.out.println("2. Remove Product");
                System.out.println("3. Find Product by SKU");
                System.out.println("4. Display inventory by SKU");
                System.out.println("5. Display inventory by Title");
                System.out.println("6. Process a sale");
                System.out.println("7. Quit the Program\n");
        }

        /**
        * takes user input to make menu selection
        * @param inventory the inventory being used by driver
        * @param sc the scanner being used by driver to read in user data
        */
        public static void getInput(Inventory inventory, Scanner sc){

                int sku, selection;
                
                
                System.out.println("Enter your choice: ");

                if(sc.hasNextInt()){
                        selection = sc.nextInt();
                }else{
                        System.out.println("Invalid input");
                        return;
                }

                switch(selection){

                        case 1: getProductInfo(inventory, sc);
                                break;

                        case 2: 
                                System.out.println("Enter the SKU:");

                                if(sc.hasNextInt()){
                                    sku = sc.nextInt();
                                }else{
                                    System.out.println("Invalid input");
                                    return;
                                }

                                inventory.removeProduct(sku);
                                break;

                        case 3:
                                System.out.println("Enter the SKU:");

                                if(sc.hasNextInt()){
                                    sku = sc.nextInt();
                                }else{
                                    System.out.println("Invalid input");
                                    return;
                                }

                                inventory.displayProduct(sku);
                                break;

                        case 4:
                                inventory.displayInventoryBySku();
                                break;

                        case 5:
                                inventory.displayInventoryByTitle();
                                break;
                        case 6:
                                sale(inventory, sc);
                                break;
                        case 7:
                                save(inventory);
                                break;
                        default:
                                System.out.println("Invalid Choice");
                                break;
                }
        }

        /**
        * takes user input process sale
        * @param inventory the inventory to process the sale
        * @param sc the scanner used by driver to read in user data
        */
        public static void sale(Inventory inventory, Scanner sc){

            int sku, quantity;
            float cost;

            System.out.println("Enter the SKU of sold items:");

            if(sc.hasNextInt()){
                sku = sc.nextInt();
            }else{
                System.out.println("Invalid input");
                return;
            }

            System.out.println("Enter the quantity sold items:");

            if(sc.hasNextInt()){
                quantity = sc.nextInt();
            }else{
                System.out.println("Invalid input");
                return;
            }

            System.out.println("Enter cost to ship sold items:");

            if(sc.hasNextFloat()){
                cost = sc.nextFloat();
            }else{
                System.out.println("Invalid input");
                return;
            }

            inventory.processSale(sku, quantity, cost);
        }

        /**
        * takes user input to add product to inventory
        * @param inventory the inventory to add product to
        * @param sc the scanner used by driver to read in user data
        */
        public static void getProductInfo(Inventory inventory, Scanner sc){

            int sku, quantity, upc, isbn;
            String title, selection, author;
            float price, weight;

            System.out.println("Enter the product type.");
            System.out.println("Enter M for movie, B for Book, or T for Toy:");
            sc.nextLine();
            selection = sc.nextLine();

            System.out.println("Enter the SKU:");

            if(sc.hasNextInt()){
                sku = sc.nextInt();
            }else{
                System.out.println("Invalid input");
                return;
            }

            System.out.println("Enter the title:");
            sc.nextLine();
            title = sc.nextLine();

            System.out.println("Enter the price:");

            if(sc.hasNextFloat()){
                price = sc.nextFloat();
            }else{
                System.out.println("Invalid input");
                return;
            }

            System.out.println("Enter the quantity:");

            if(sc.hasNextInt()){
                quantity = sc.nextInt();
            }else{
                System.out.println("Invalid input");
                return;
            }
            switch(selection){

                case "M":
                case "m":

                    System.out.println("Enter the UPC:");

                    if(sc.hasNextInt()){
                        upc = sc.nextInt();
                    }else{
                        System.out.println("Invalid input");
                        return;
                    }

                    inventory.addMovie(sku, title, price, quantity, upc);
                    break;

                case "B":
                case "b":

                    System.out.println("Enter the ISBN:");

                    if(sc.hasNextInt()){
                        isbn = sc.nextInt();
                    }else{
                        System.out.println("Invalid input");
                        return;
                    }
                    System.out.println("Enter the author:");
                    sc.nextLine();
                    author = sc.nextLine();

                    inventory.addBook(sku, title, price, quantity, isbn, author);
                    break;

                case "T":
                case "t":
                    System.out.println("Enter the weight in ounces:");

                    if(sc.hasNextFloat()){
                        weight = sc.nextFloat();
                    }else{
                        System.out.println("Invalid input");
                        return;
                    }

                    inventory.addToy(sku, title, price, quantity, weight);

                break;
            }
        }

        /**
        * serializes inventory and sets run flag to false
        * @param inventory the inventory to serialize
        */
        public static void save(Inventory inventory){
            try {
                FileOutputStream fos = new FileOutputStream("movieInventory");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(inventory); 
                fos.close();
            } catch (IOException e) {
                System.out.println("Problem with file output");
            }
            Driver.run = false;
        }
}