package com.challenge.backend.utils;

import java.util.ArrayList;
import java.util.List;


// Classes
import com.challenge.backend.model.entities.Item;
import com.challenge.backend.model.classes.Product;
import com.challenge.backend.model.classes.ProdCount;

public class Items {
    
    // Returns a List of Items(Products Information)
    public static List<Item> itemsList(ArrayList<ProdCount> p, ArrayList<Product> finalListProd) {
        
        List<Item> items = new ArrayList<Item>();
        
        for(ProdCount prod : p) {
            Double price = 0d;
            for(Product product : finalListProd) {
                if(product.getId() == prod.getId()) {
                    price = product.getPrice();
                } else {
                    continue;
                }
            }
            items.add(new Item(prod.getId(), price, prod.getQtd(), (prod.getQtd() * price)));
        }

        return items;
    }
}
