package com.challenge.backend.services;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

//Classes
import com.challenge.backend.model.entities.OrderVivo;
import com.challenge.backend.model.DTOs.CreateOrderDto;
import com.challenge.backend.model.DTOs.UpdateOrderDto;
import com.challenge.backend.model.DTOs.UpdateOrderStatusDto;
import com.challenge.backend.model.classes.Product;
import com.challenge.backend.model.classes.User;
import com.challenge.backend.model.entities.Item;
import com.challenge.backend.model.classes.ProdCount;
import com.challenge.backend.utils.Convert;
import com.challenge.backend.utils.AmountVerify;
import com.challenge.backend.utils.HttpReq;
import com.challenge.backend.utils.Items;
import com.google.gson.Gson;
import com.challenge.backend.model.enums.Status;
import com.challenge.backend.repositories.ItemsRepo;
import com.challenge.backend.repositories.OrdersRepo;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepo repo;

    @Autowired
    private ItemsRepo itemsrepo;

    private boolean userExists = false;

    // Saves an Order
    public OrderVivo save(CreateOrderDto order) throws IOException, InterruptedException {

        // Products API Accesss
        HttpResponse<String> prods = HttpReq.req("https://fakestoreapi.com/products");

        // Users API Accesss
        HttpResponse<String> users = HttpReq.req("https://fakestoreapi.com/users");

        // Convert request to array of Products
        ArrayList<Product> finalListProd = Convert.toProducts(prods.body());
        
        // Convert request to array of Users
        ArrayList<User> finalListUser = Convert.toUsers(users.body());

        // Verify if user exists
        finalListUser.forEach(user -> {
            if (user.getId() == order.getUserId()) {
                userExists = true;
            }
        });

        // Finalize Process
        if (userExists) {

            // Verify Amount
            ArrayList<ProdCount> p = AmountVerify.verify(order);

            // Returns a List with Items(Product information)
            List<Item> items = Items.itemsList(p, finalListProd);

            // Calculate Total Price
            Double total = 0d;
            for(Item i: items) {
                total += i.getPA();
            }
    
            OrderVivo finalOrder = new OrderVivo(order.getUserId(), Status.PENDING, total);
            
            this.repo.save(finalOrder);

            for(Item i: items) {
                i.setOrder(finalOrder);
                this.itemsrepo.save(i);
            }

            finalOrder.setItems(items);

            return finalOrder;
        } else {
            throw new IOException();
        }

    }

    // Updates an Order Status
    public OrderVivo updateStatus(String updatedOrder) {

        Gson g = new Gson();
        UpdateOrderStatusDto dto = g.fromJson(updatedOrder, UpdateOrderStatusDto.class);

        return this.repo.findById(dto.getId()).map( order -> {
            if (dto.getUserId() == order.getUserId()) {
                order.setStatus(Status.CONCLUDED);
            }
            return this.repo.save(order);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // Updates an Order
    public OrderVivo update(String updatedOrder) throws IOException, InterruptedException {

        Gson g = new Gson();
        UpdateOrderDto dto = g.fromJson(updatedOrder, UpdateOrderDto.class);

        return this.repo.findById(dto.getId()).map( order -> {
            if (dto.getUserId() == order.getUserId()) {

                for (int ui = dto.getItems().size() - 1; ui >= 0; ui--) {
                    for (Item i: order.getItems()) {
                        if (dto.getItems().get(ui).getId() == i.getId()) {
                            i.setAmount(i.getAmount() + 1);
                            i.setPA(i.getPA() + i.getPrice());
                            dto.getItems().get(ui).setId(0);
                        } else {
                            continue;

                        }
                    }
                }

                // Removes repeated products
                for (int ui = dto.getItems().size() - 1; ui >= 0; ui--) {
                    if (dto.getItems().get(ui).getId() == 0) {
                        dto.getItems().remove(dto.getItems().get(ui));
                    }
                } 

                // Add new Products if they exists
                if(dto.getItems().size() > 0) {
                    
                    try {
                        // Products API Accesss
                        HttpResponse<String> prods = HttpReq.req("https://fakestoreapi.com/products");
                        
                        // Convert request to array of Products
                        ArrayList<Product> finalListProd = Convert.toProducts(prods.body());

                        // Verify Amount
                        ArrayList<ProdCount> p = AmountVerify.verify(new CreateOrderDto(dto.getUserId(), dto.getItems()));

                        // Returns a List with Items(Product information)
                        List<Item> items = Items.itemsList(p, finalListProd);

                        // Add new Items to Order
                        for (Item i: items) {
                            order.getItems().add(i);
                        }

                        for(Item i: items) {
                            i.setOrder(order);
                            this.itemsrepo.save(i);
                        }

                    } catch (IOException e) {
                        
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                    }                    
                }
            }

            // Calculate new Total Price
            Double total = 0d;
            for(Item i: order.getItems()) {
                total += i.getPA();
            }

            order.setTotalPrice(total);

            return this.repo.save(order);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
