package StorePackage;
import java.util.*;

/**
* comparator for products to sort by title
* @author Cody Blakeney
*/
public class ProductByTitle implements Comparator<Product>{
    /**
    * compares to Products by title
    * @param lhs "left hand side" product to compare
    * @param rhs "right hand side" product to compare
    * @return positive, negative or zero depending on lhs value vs rhs
    */
    public int compare(Product lhs, Product rhs){
        return lhs.getTitle().compareTo(rhs.getTitle());
    }
}