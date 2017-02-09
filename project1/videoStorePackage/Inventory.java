package videoStorePackage;

import java.util.ArrayList;
import java.text.*;
import java.io.*;

public class Inventory implements Serializable{

        private ArrayList<Movie> movies;

        Inventory(){
                this.movies = new ArrayList<Movie>();
        }
        /**
        *@param sku number of movie
        *@param title String name of movie
        *@param price float of movie price
        *@param quantity of movie
        */
        public void addMovie(int sku, String title, float price, int quantity){

                

                this.movies.add(new Movie(sku, title, price, quantity));
        }

        /**
        * removes a movie from inventory given an sku
        *@param sku number of movie to be removed
        */
        public void removeMovie(int sku){

                

                for(int i = 0; i < this.movies.size(); i++){
                        if(this.movies.get(i).getSku() == sku){
                                this.movies.remove(i);
                                return;
                        }
                }

                System.out.println("No movie found with this sku. ");              
        }

        /**
        * displays information about movie given an sku
        *@param sku
        */
        public void displayMovie(int sku){
                DecimalFormat dff = new DecimalFormat("$#00.00");

                for(Movie movie : this.movies){
                        if(movie.getSku() == sku){
                                System.out.println("\nsku=" + sku + ",");
                                System.out.println("title=" + movie.getTitle() + ",");
                                System.out.println("price=" + dff.format(movie.getPrice()) + ",");
                                System.out.println("quantity=" + movie.getQuanity());
                                return;
                        }  
                }

                System.out.println("No movie found with this sku. ");
        }

        public void displayInventory(){

            DecimalFormat dff = new DecimalFormat("$#00.00");

            System.out.println();
                for(Movie movie : this.movies){

                        System.out.println(movie.getSku() 
                                           + "\t"
                                           + movie.getQuanity()
                                           + "  " + dff.format(movie.getPrice()) 
                                           + "  "
                                           + movie.getTitle()
                                           );
                }
        }
}