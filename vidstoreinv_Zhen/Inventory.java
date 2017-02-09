package vidstoreinv;

import java.io.*;
import java.util.*;

/**
 * An inventory which creates, stores, displays and removes movies
 * @author Eugene (Zhenya) Hanson
 */
public class Inventory{
    private ArrayList<Movie> movies;
    
    /**
     * constructs a new ArrayList of Movies; from a file if it can
     */
    public Inventory() {
        boolean loadedFromFile = true;
        try {
            FileInputStream fis = new FileInputStream("inventoryFilez");
            ObjectInputStream ois = new ObjectInputStream(fis);
            movies = (ArrayList<Movie>)ois.readObject(); // explicit cast reqd
            fis.close();
        } catch (FileNotFoundException e) {
            //System.out.println("Cannot find datafile.");
            loadedFromFile = false;
        } catch (IOException e) {
            //System.out.println("Problem with file input.");
            loadedFromFile = false;
        } catch (ClassNotFoundException e) {
            //System.out.println("Class not found on input from file.");
            loadedFromFile = false;
        }
    
        if(!loadedFromFile)
            movies = new ArrayList<Movie>();
    }
    
    /**
     * adds a movie to the inventory if it can
     * @param stockKeepingUnit the sku of the movie
     * @param title the title of the movie
     * @param price the price of the movie
     * @param quantity the quantity of movies
     */
    public void add(int stockKeepingUnit, String title, double price, int quantity) {
        for(Movie movie : movies){
            if(movie.matchingSKU(stockKeepingUnit)) {
                System.out.println("SKU already exists.");
                return;
            }
        }
        if(!(price > 0)){
            System.out.println("Invalid price.");
            return;
        }
        if(quantity < 0){
            System.out.println("Invalid quantity");
        }
        
        movies.add(new Movie(stockKeepingUnit,title,price,quantity));
    }
    
    /**
     * Removes a movie
     * @param stockKeepingUnit the SKU of the movie to be removed
     */
    public void remove(int stockKeepingUnit) {
        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).matchingSKU(stockKeepingUnit)) {
                movies.remove(i);
                return;
            }
        }
        System.out.println("No movie found with this sku.");
    }
    
    /**
     * Displays a movie
     * @param stockKeepingUnit the SKU of the movie to be displayed
     */
    public void display(int stockKeepingUnit) {
        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).matchingSKU(stockKeepingUnit)) {
                System.out.println(movies.get(i).formattedForMovie());
                return;
            }
        }
        System.out.println("No movie found with this sku.");
    }
    
    /**
     * Displays a table of the movies in inventory in the order in
     * which they were input.
     */
    public void displayTable() {
        for(Movie movie : movies)
            System.out.println(movie.formattedForTable());
    }
    
    /**
     * Stores the inventory in a file by way of serialization.
     */
    public void storeInventory() {
        
        //the following code writes the objects to the file:
        try {
            FileOutputStream fos = new FileOutputStream("inventoryFilez");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(movies); //ArrayList & contents are serializable
            fos.close();
        } catch (IOException e) {
            System.out.println("Problem with file output");
        }
    }
    
}
