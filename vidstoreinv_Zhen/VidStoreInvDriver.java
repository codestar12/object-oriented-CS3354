package vidstoreinv;

import java.io.*;
import java.util.*;
/**
 * Driver class, the view.
 * @author Eugene (Zhenya) Hanson
 */
public class VidStoreInvDriver {

    /**
     * driving function behind the user's interaction with the inventory
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String choice = "0";
        Scanner input = new Scanner(System.in);
        Inventory inv = new Inventory();
        
        int userSKU;
        String userTitle;
        double userPrice;
        int userQuantity;
        while(!choice.equals("5")) {
            if(!choice.equals("0"))
                System.out.println();
            
            System.out.println("Video Store Inventory Menu");
            System.out.println("");
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie");
            System.out.println("3. Find Movie by SKU");
            System.out.println("4. Display inventory");
            System.out.println("5. Quit the Program");
            System.out.println("");
            System.out.println("Enter your choice:");
            choice = input.nextLine();
            
            if(choice.equals("1")) {
                System.out.println("Enter the SKU:");
                userSKU = input.nextInt();
                input.nextLine();
                System.out.println("Enter the title:");
                userTitle = input.nextLine();
                System.out.println("Enter the price:");
                userPrice = input.nextDouble();
                input.nextLine();
                System.out.println("Enter the quantity:");
                userQuantity = input.nextInt();
                input.nextLine();
                
                inv.add(userSKU, userTitle, userPrice, userQuantity);
            }
            if(choice.equals("2")) {
                System.out.println("Enter SKU of movie to remove:");
                userSKU = input.nextInt();
                input.nextLine();
                inv.remove(userSKU);
            }
            if(choice.equals("3")) {
                System.out.println("Enter SKU of movie to find:");
                userSKU = input.nextInt();
                input.nextLine();
                inv.display(userSKU);
            }
            if(choice.equals("4")) {
                System.out.println();
                inv.displayTable();
            }
            if(choice.equals("5")) {
                System.out.println("Exit selected");
                inv.storeInventory();
            }
        }
        
    }
}
