package StorePackage;

import java.io.*;
import java.text.*;

/**
* movie product item
* @author Cody Blakeney
*/
public class Movie extends Product{

    private int upc;

    Movie(int sku, String title, float price, int quantity, int upc){
            super(sku, title, price, quantity);
            this.upc = upc;
    }

    public String formattedForProduct(){
        return super.formattedForProduct() + "\nUPC=" + this.upc;

    }

    public String formattedForInventory(){
            return "Movie\t" + super.formattedForInventory();
    }

    /**
    * calculates the commisson based on rate for toy
    * @param totalPrice price of item times number to be sold
    * @return commission cost
    */ 
    public float calculateCommission(float totalPrice){
        return totalPrice * .12f;
    }

    /**
    * calculates shipping credit for store
    * @param itemsSold number of items to be sold
    * @return shipping credit
    */
    public float claculateShippingCredit(int itemsSold){
        return itemsSold * 2.89f;
    }

    /**
    *@return returns upc of movie
    */
    public int getUpc(){
       return upc;
    }
}