package StorePackage;

import java.io.*;
import java.text.*;

/**
* Book product item
* @author Cody Blakeney
*/
public class Book extends Product{
    private int isbn;
    private String author;

    Book(int sku, String title, float price, int quantity, int isbn, String author){
            super(sku, title, price, quantity);
            this.isbn = isbn;
            this.author = author;
    }
    
    /**
    *@return isbn of book
    */
    public int getIsbn(){
        return isbn;
    }

    /**
    *@return authoer of book
    */
    public String getAuthor(){
        return author;
    }

    public String formattedForProduct(){
        return super.formattedForProduct() + 
               "\nisbn=" + this.isbn + 
               "\nauthor=" + this.author;
    }

    public String formattedForInventory(){
            return "Book\t" + super.formattedForInventory();
    }

    /**
    * calculates the commisson based on rate for book
    * @param totalPrice price of item times number to be sold
    * @return commission cost
    */
    public float calculateCommission(float totalPrice){
        return totalPrice * .15f;
    }

    /**
    * calculates shipping credit for store
    * @param itemsSold number of items to be sold
    * @return shipping credit
    */
    public float claculateShippingCredit(int itemsSold){
        return itemsSold * 3.99f;
    }
}