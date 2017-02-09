package videoStorePackage;

import java.util.*;
import java.io.*;

public class Driver{

        public static boolean run = true;

        public static void main(String[] args){
                Inventory inventory = new Inventory();

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
                        getInput(inventory);
                }
        }

        public static void displayMenu(){
                System.out.println("\nVideo Store Inventory Menu\n");
                System.out.println("1. Add Movie");
                System.out.println("2. Remove Movie");
                System.out.println("3. Find Movie by SKU");
                System.out.println("4. Display inventory");
                System.out.println("5. Quit the Program\n");
        }

        public static void getInput(Inventory inventory){
                Scanner sc = new Scanner(System.in);
                int sku, selection;
                
                System.out.println("Enter your choice: ");

                if(sc.hasNextInt()){
                        selection = sc.nextInt();
                }else{
                        System.out.println("Invalid input");
                        return;
                }

                switch(selection){

                        case 1: getMovieInfo(inventory);
                                break;

                        case 2: 
                                System.out.println("Enter the SKU:");

                                if(sc.hasNextInt()){
                                    sku = sc.nextInt();
                                }else{
                                    System.out.println("Invalid input");
                                    return;
                                }

                                inventory.removeMovie(sku);
                                break;

                        case 3:
                                System.out.println("Enter the SKU:");

                                if(sc.hasNextInt()){
                                    sku = sc.nextInt();
                                }else{
                                    System.out.println("Invalid input");
                                    return;
                                }

                                inventory.displayMovie(sku);
                                break;

                        case 4:
                                inventory.displayInventory();
                                break;

                        case 5:
                                save(inventory);
                                break;
                        default:
                                System.out.println("Invalid Choice");
                                break;
                }
        }

        public static void getMovieInfo(Inventory inventory){
            Scanner sc = new Scanner(System.in);
            int sku, quantity;
            String title;
            float price;

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

            inventory.addMovie(sku, title, price, quantity);


        }

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