package com.example.suprdaily.controller;

import com.example.suprdaily.model.OrderRequest;
import com.example.suprdaily.service.CategoryServiceClass;
import com.example.suprdaily.service.OrderServiceClass;

public class OrderController {
    CategoryServiceClass catService;
    OrderServiceClass orderService;
    public OrderController(){
        catService=new CategoryServiceClass();
        orderService=new OrderServiceClass();
    }
    //API canFulfil
    public boolean canFulfil(OrderRequest orderRequest){
        try {
            catService.isReservePossible(orderRequest);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        try {
            orderService.isReservePossible(orderRequest);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    //API Reserve An Order
    public boolean reserveOrder(OrderRequest orderRequest){
        if (canFulfil(orderRequest)){
            return true;
        }
            return false;
    }

    //insert
    public void insertOrder(OrderRequest orderRequest){
        catService.insert(orderRequest);
        orderService.insert(orderRequest);
    }

}
