package com.example.suprdaily.service;

import com.example.suprdaily.model.ItemRequest;
import com.example.suprdaily.model.OrderRequest;

import java.util.HashMap;

public class CategoryServiceClass {
    HashMap<String,Integer> CategoryQuantityMapping;
    public CategoryServiceClass(){
        CategoryQuantityMapping=new HashMap<>();
    }
    public void insert(OrderRequest orderRequest) {
        for (ItemRequest itemRequest : orderRequest.getItems()) {
            int oldQuantityCount = 0;
            if (CategoryQuantityMapping.containsKey(itemRequest.getItem().getCategory())) {
                oldQuantityCount = CategoryQuantityMapping.get(itemRequest.getItem().getCategory());
            }
            CategoryQuantityMapping.put(itemRequest.getItem().getCategory(),oldQuantityCount+ itemRequest.getQuantity());
        }
    }

    public void isReservePossible(OrderRequest orderRequest) throws Exception {
        for (ItemRequest itemRequest : orderRequest.getItems()) {
            int oldQuantityCount = 0;
            if (CategoryQuantityMapping.containsKey(itemRequest.getItem().getCategory())) {
                oldQuantityCount = CategoryQuantityMapping.get(itemRequest.getItem().getCategory());
            }
            if(oldQuantityCount<itemRequest.getQuantity())
            {
                throw new Exception("Not possible Item quantity is less");
            }
        }
    }

    public void Reserve(OrderRequest orderRequest) throws Exception {
        for (ItemRequest itemRequest : orderRequest.getItems()) {
            int oldQuantityCount = 0;
            oldQuantityCount = CategoryQuantityMapping.get(itemRequest.getItem().getCategory());

            CategoryQuantityMapping.put(itemRequest.getItem().getCategory(),oldQuantityCount- itemRequest.getQuantity());

        }
    }

}
