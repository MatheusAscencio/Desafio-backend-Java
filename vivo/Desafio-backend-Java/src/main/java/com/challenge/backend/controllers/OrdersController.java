package com.challenge.backend.controllers;

import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;


// Classes
import com.challenge.backend.model.DTOs.CreateOrderDto;
import com.challenge.backend.model.DTOs.UpdateOrderDto;
import com.challenge.backend.model.entities.OrderVivo;
import com.challenge.backend.services.OrdersService;

@RestController
@RefreshScope
@RequestMapping(value = "/orders")
public class OrdersController {
    
    private Logger logger = LoggerFactory.getLogger(OrdersController.class.getName());

    @Autowired
    private OrdersService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderVivo> save(@RequestBody @Valid CreateOrderDto order) {

        logger.info("Save Order API Accessed!");

        try {

            OrderVivo finishedOrder = this.service.save(order);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(finishedOrder.getId()).toUri();
            return ResponseEntity.created(uri).body(finishedOrder);

        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderVivo> update(@RequestBody @Valid String updatedO) {

        logger.info("Update Order API Accessed!");
        
        try {

            System.out.println(updatedO);

            OrderVivo finishedOrder = new OrderVivo();

            if(updatedO.contains("status")) {
                finishedOrder = this.service.updateStatus(updatedO);
            } else {
                finishedOrder = this.service.update(updatedO);
            }

            return ResponseEntity.ok().body(finishedOrder);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
