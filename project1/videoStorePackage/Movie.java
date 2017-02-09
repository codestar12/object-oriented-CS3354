package videoStorePackage;

import java.io.*;
class Movie implements Serializable{
        private int sku, quantity;
        private String title;
        private float price;

        //Movie(){}

        Movie(int sku, String title, float price, int quantity){
                this.sku = sku;
                this.title = title;
                this.price = price;
                this.quantity = quantity;
        }

        public int getSku(){
                /**
                *@return sku of movie
                */
                return sku;
        }

        public String getTitle(){
                /**
                *@return title of movie
                */
                return title;
        }

        public float getPrice(){
                /**
                *@return prive of movie
                */
                return price;
        }

        public int getQuanity(){
                /**
                *@return quantity of movie
                */
                return quantity;
        }

}