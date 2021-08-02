package com.ak.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    Map<Product, Integer> pp2_pn;
    Integer pp2_price = 0;
     Cart()
     {
         pp2_pn = new LinkedHashMap<>();
     }
     void addToCart(Product product)
     {
         if(pp2_pn.containsKey(product))
             pp2_pn.put(product, pp2_pn.get(product)+1);
         else
             pp2_pn.put(product,1);
         pp2_price += product.getPrice();
     }
     int getQuantity(Product product){
         return pp2_pn.get(product);
     }
     Set getProducts()
     {
         return pp2_pn.keySet();
     }
     void empty()
     {
         pp2_pn.clear();
         pp2_price = 0;
     }
     Integer getPrice()
     {
         return pp2_price;
     }
     int getSize()
     {
         return pp2_pn.size();
     }
}
