package StorePackage;

import java.util.*;
import java.text.*;
import java.io.*;

/**
* inventory for a store which sells books, movies and toys
* @author Cody Blakeney
*/
public class Inventory implements Serializable{

        private ArrayList<Product> products;

        Inventory(){
                this.products = new ArrayList<Product>();
        }
        /**
        * adds new movie to inventory
        *@param sku sku number of movie
        *@param title title String name of movie
        *@param price price float of movie price
        *@param quantity quantity of movie
        *@param upc upc of movie
        */
        public void addMovie(int sku, String title, float price, int quantity, int upc){

            for(Product item : this.products){
                    if(item.getSku() == sku){
                        System.out.println("sku already exists");
                        return;
                    }  
            }

            this.products.add(new Movie(sku, title, price, quantity, upc));
        }
        /**
        * adds new book to inventory
        *@param sku sku number of book
        *@param title title String name of book
        *@param price price float of book price
        *@param quantity quantity of book
        *@param isbn isbn of book
        *@param author author of book
        */
        public void addBook(int sku, String title, float price, int quantity, int isbn, String author){

           for(Product item : this.products){
                if(item.getSku() == sku){
                    System.out.println("sku already exists");
                    return;
                }  
            }

            this.products.add(new Book(sku, title, price, quantity, isbn, author));
        }

        /**
        * adds new toy to inventory
        *@param sku sku number of toy
        *@param title title String name of toy
        *@param price price float of toy price
        *@param quantity quantity of toy
        *@param weight weight of toy in ounces
        */
        public void addToy(int sku, String title, float price, int quantity, float weight){

            for(Product item : this.products){
                if(item.getSku() == sku){
                    System.out.println("sku already exists");
                    return;
                }  
            }

            this.products.add(new Toy(sku, title, price, quantity, weight));
        }

        /**
        * removes a item from inventory given an sku
        *@param sku sku number of item to be removed
        */
        public void removeProduct(int sku){

                for(int i = 0; i < this.products.size(); i++){
                        if(this.products.get(i).getSku() == sku){
                                this.products.remove(i);
                                return;
                        }
                }

                System.out.println("No item found with this sku. ");              
        }

        /**
        * processes a sale of an item given sku if there are enough in inventory
        * @param sku sku of item to be sold
        * @param itemsSold number of items being sold
        * @param shippingCost the cost to the store to ship items
        */
        public void processSale(int sku, int itemsSold, float shippingCost){
            DecimalFormat dff = new DecimalFormat("$#00.00");
            for(Product item : this.products){
                if(item.getSku() == sku){
                    if(item.getQuantity() >= itemsSold){
                        item.reduceQuantity(itemsSold);
                        System.out.println(item.formattedForSale(itemsSold) + 
                                           dff.format(item.subTotal(itemsSold) - 
                                           shippingCost));
                    }else{
                        System.out.println("Not enough proecut in inventory");
                    }
                    return;
                }  
            }

            System.out.println("No item found with this sku. ");
        }

        /**
        * displays information about a product given an sku
        *@param sku sku of product to display
        */
        public void displayProduct(int sku){

                for(Product item : this.products){
                        if(item.getSku() == sku){
                            System.out.println(item.formattedForProduct());
                            return;
                        }  
                }

                System.out.println("No item found with this sku. ");
        }

        /** outputs a table of inventory items sorted by sku # */
        public void displayInventoryBySku(){

            Comparator<Product> comp = new ProductBySku();
            Collections.sort(this.products, comp);


            DecimalFormat dff = new DecimalFormat("$#00.00");

            System.out.println();
                for(Product item : this.products){

                    System.out.println(item.formattedForInventory());
                }
        }

        /** outputs a table of inventory items sorted by title */
        public void displayInventoryByTitle(){

            Comparator<Product> comp = new ProductByTitle();
            Collections.sort(this.products, comp);

            DecimalFormat dff = new DecimalFormat("$#00.00");

            System.out.println();
                for(Product item : this.products){

                    System.out.println(item.formattedForInventory());
                }
        }
}