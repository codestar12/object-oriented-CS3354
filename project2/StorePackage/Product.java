package StorePackage;

import java.io.*;
import java.text.*;

/**
* Product abstract class for inventory
* @author Cody Blakeney
*/
public abstract class Product implements Serializable{
    private int sku, quantity;
    private String title;
    private float price;

    Product(int sku, String title, float price, int quantity){
            this.sku = sku;
            this.title = title;
            this.price = price;
            this.quantity = quantity;
    }

    /**
    *@return sku of movie
    */
    public int getSku(){
           
            return sku;
    }
    /**
    *@return title of movie
    */
    public String getTitle(){
            
            return title;
    }

    /**
    *@return price of movie
    */
    public float getPrice(){
            
            return price;
    }

    /**
    *@return quantity of movie
    */
    public int getQuantity(){
            return quantity;
    }

    /**
    * reduces value of quantity when processing a sale
    * @param reduction amount to reduce quantity by
    */
    public void reduceQuantity(int reduction){
        this.quantity = this.quantity - reduction;
    }

    /** 
    * creates a string of product information formated for an
    * individual product
    * @return string of product info
    */
    public String formattedForProduct(){
        DecimalFormat dff = new DecimalFormat("$#00.00");
        return "\nsku=" + this.getSku() + "," +
                "\ntitle=" + this.getTitle() + "," +
                "\nprice=" + dff.format(this.getPrice()) + "," +
                "\nquantity=" + this.getQuantity();
    }

    /** 
    * creates a string of product information formated for an
    * an entire inventory output
    * @return string of product info
    */
    public String formattedForInventory(){
        DecimalFormat dff = new DecimalFormat("$#00.00");
        return this.getSku() + "\t" + 
               this.getQuantity() + "  " + 
               dff.format(this.getPrice()) + "  " + 
               this.getTitle();
                                           
    }

    /** 
    * creates a string of sales information about product
    * @param itemsSold number of items being sold
    * @return string of product salse info
    */
    public String formattedForSale(int itemsSold){
        float totalPrice = itemsSold * this.getPrice();
        DecimalFormat dff = new DecimalFormat("$#00.00");
        return "Total Price: \t\t" + dff.format(totalPrice) +
               "\nTotal shipping Credit: \t" + dff.format(this.claculateShippingCredit(itemsSold)) +
               "\nTotal commission: \t" + dff.format(this.calculateCommission(totalPrice)) +
               "\nProfit \t\t\t"; 
    }

    /**
    * calculates subtotal of profit before cost of shipping for store
    * @param itemsSold number of items sold
    * @return subtotal of profit from sale
    */
    public float subTotal(int itemsSold){
        float totalPrice = itemsSold * this.getPrice();
        return totalPrice + 
               this.claculateShippingCredit(itemsSold) - 
               this.calculateCommission(totalPrice);
    }

    /** 
    * Returns value of shipping credit specific to product type 
    * @param itemsSold number of items sold
    * @return value of shipping credit
    */
    abstract public float claculateShippingCredit(int itemsSold);
    /** 
    *Returns value of commission specific to product type 
    *@param totalPrice value of items times number of items being sold
    *@return total value of commission to be paid
    */
    abstract public float calculateCommission(float totalPrice);



}