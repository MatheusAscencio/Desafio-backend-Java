package com.challenge.backend.utils;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;


// Classes
import com.challenge.backend.model.classes.Product;
import com.challenge.backend.model.classes.User;

public class Convert {
    
    // Convert to a List of Products
    public static ArrayList<Product> toProducts(String body) {

        ArrayList<Product> list = new ArrayList<Product>();
        
        String newBody = body.substring(1, (body.length() - 1));

        String[] array = newBody.split("},");

        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(array));

        Gson g = new Gson(); 
        
        for (int i = 0; i < strList.size(); i++) {
            if(i < (strList.size() - 1)) {
                strList.set(i, strList.get(i) + "}");
            }
            list.add(g.fromJson(strList.get(i), Product.class));
        }

        return list;
         
    }


    // Convert to a List of Users
    public static ArrayList<User> toUsers(String body) {
        
        ArrayList<User> list = new ArrayList<User>();
        
        String newBody = body.substring(1, (body.length() - 1));

        String[] array = newBody.split("\"__v\":0},");

        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(array));

        Gson g = new Gson(); 
        
        for (int i = 0; i < strList.size(); i++) {
            if(i < (strList.size() - 1)) {
                strList.set(i, strList.get(i) + "\"__v\": 0}");
            }
            list.add(g.fromJson(strList.get(i), User.class));
        }

        return list;
    }
}
