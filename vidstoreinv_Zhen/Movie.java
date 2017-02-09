package vidstoreinv;

import java.io.Serializable;
import java.util.*;

/**
 * a class to hold data about a movie a long with methods to help other classes
 * compare and display movies. Movies are immutable
 * @author Eugene (Zhenya) Hanson
 */
public class Movie implements Serializable{
    private int stockKeepingUnit;
    private String title;
    private double price;
    private int quantity;
    
    /**
     * construct a new movie object
     * @param stockKeepingUnit the SKU of the movie
     * @param title the title of the movie
     * @param price the price of the movie
     * @param quantity the quantity of movies
     */
    public Movie(int stockKU, String title, double price ,int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.stockKeepingUnit = stockKU;
        this.title = title;
    }
    
    /**
     * formats the movie data to be output into a table
     * @return formatted string
     */
    public String formattedForTable() {
        String formatSKU = "%5d";
        String formatQuantity = "%5d";
        String formatPrice = "%.2f";
        
        return String.format(formatSKU, stockKeepingUnit) + " "
                + String.format(formatQuantity, quantity)  + "   $"
                + String.format(formatPrice, price)  + " "
                + this.title;
    }
    
    /**
     * formats the movie data to be output by itself
     * @return formatted string
     */
    public String formattedForMovie() {
        return "sku="+stockKeepingUnit
                +",\ntitle="+title
                +",\nprice=$"+String.format("%.2f", price)
                +",\nquantity="+quantity;
    }
    
    /**
     * A method to check if an SKU matches the one this movie has
     * @param potentialSKU an stock keeping unit to check against this movie's
     * @return true if they are the same SKU, false if not
     */
    public boolean matchingSKU(int potentialSKU) {
        return stockKeepingUnit == potentialSKU;
    }
}
