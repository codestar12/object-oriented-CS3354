package StorePackage;
import java.util.*;

/**
* comparator for products to sort by sku
* @author Cody Blakeney
*/
public class ProductBySku implements Comparator<Product>{
    /**
    * compares to Products by sku number
    * @param lhs "left hand side" product to compare
    * @param rhs "right hand side" product to compare
    * @return positive, negative or zero depending on lhs value vs rhs
    */
    public int compare(Product lhs, Product rhs){
        int lhsSku = lhs.getSku();
        int rhsSku = rhs.getSku();
        if(lhsSku < rhsSku) return -1;
        if(lhsSku < rhsSku) return 0;
        return 1;
    }
}