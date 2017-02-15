package StorePackage;

import java.io.*;
import java.text.*;
import java.lang.Math;

/**
* movie product item
* @author Cody Blakeney
*/
public class Toy extends Product{

        /** weight of toy in ounces */
        private float weight;

        Toy(int sku, String title, float price, int quantity, float weight){
                super(sku, title, price, quantity);
                this.weight = weight;
        }

        /** 
        * @return returns string of product information for toy
        */
        public String formattedForProduct(){
            return super.formattedForProduct() + "\nWeight=" + this.weight;
        }

        /** 
        * @return returns string of product information for toy
        */
        public String formattedForInventory(){
            return "Toy\t" + super.formattedForInventory();
        }

        /**
        * calculates the commisson based on rate for toy
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
            return itemsSold * (4.49f + .5f*(float)Math.ceil(this.weight/16) );
        }
}
