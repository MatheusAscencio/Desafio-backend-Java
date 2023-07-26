package com.challenge.backend.utils;

import java.util.ArrayList;

// Classes
import com.challenge.backend.model.DTOs.ProductDto;
import com.challenge.backend.model.classes.ProdCount;
import com.challenge.backend.model.DTOs.CreateOrderDto;

public class AmountVerify {
    
    public static ArrayList<ProdCount> verify(CreateOrderDto order) {

        ArrayList<ProdCount> p = new ArrayList<ProdCount>();

        for(ProductDto prod : order.getProducts()) {
            ProdCount pc = new ProdCount();
            
            if(prod.getId() != 0) {
                pc.setId(prod.getId());
                
                prod.setId(0);
                pc.setQtd(pc.getQtd() + 1);   
                for(ProductDto prod2 : order.getProducts()) {
                    if((prod2.getId() != 0) && (prod2.getId() == pc.getId())) {
                        pc.setQtd(pc.getQtd() + 1);
                        prod2.setId(0);
                    } else {
                        continue;
                    }
                }
                
            } else {
                continue;
            }
            p.add(pc);
        }

        return p;
    }
}
