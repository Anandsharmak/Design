package com.example.suprdaily.service;

import com.example.suprdaily.model.Item;
import com.example.suprdaily.model.ItemRequest;
import com.example.suprdaily.model.OrderRequest;

import java.util.HashMap;

public class OrderServiceClass {
    //(Date:quantity)
    HashMap<String,Integer> dateToQuantityForWarehouseAndItem;
    //(Item:(Date:quantity)
    HashMap<Integer, HashMap<String,Integer>> ItemTodateAndQuantityDetailForWarehouse;

    //Warehouse:(Item:(Date:quantity)
    HashMap<Integer,HashMap<Integer, HashMap<String,Integer>>> warehouseItemDateQuantityDetail;


    public OrderServiceClass(){
        warehouseItemDateQuantityDetail=new HashMap<>();
    }
    public void insert(OrderRequest orderRequest) {
        ItemTodateAndQuantityDetailForWarehouse = warehouseItemDateQuantityDetail.get(orderRequest.getWarehouseId());
        if (ItemTodateAndQuantityDetailForWarehouse == null) {
            ItemTodateAndQuantityDetailForWarehouse = new HashMap<>();
        }

        for (ItemRequest itemRequest : orderRequest.getItems()) {
            dateToQuantityForWarehouseAndItem = ItemTodateAndQuantityDetailForWarehouse.get(itemRequest.getItem().getItemId());
            if (dateToQuantityForWarehouseAndItem == null) {
                dateToQuantityForWarehouseAndItem = new HashMap<>();
            }
            int oldQuantity=0;
            if(dateToQuantityForWarehouseAndItem.containsKey(orderRequest.getDeliveryDate())){
                oldQuantity=dateToQuantityForWarehouseAndItem.get(orderRequest.getDeliveryDate());
            }

            dateToQuantityForWarehouseAndItem.put(orderRequest.getDeliveryDate(), oldQuantity+itemRequest.getQuantity());
            ItemTodateAndQuantityDetailForWarehouse.put(itemRequest.getItem().getItemId(), dateToQuantityForWarehouseAndItem);
        }
    }

    public void reserve(OrderRequest orderRequest) throws Exception {
        ItemTodateAndQuantityDetailForWarehouse = warehouseItemDateQuantityDetail.get(orderRequest.getWarehouseId());

        for (ItemRequest itemRequest : orderRequest.getItems()) {
            dateToQuantityForWarehouseAndItem = ItemTodateAndQuantityDetailForWarehouse.get(itemRequest.getItem().getItemId());
            int oldQuantity=dateToQuantityForWarehouseAndItem.get(orderRequest.getDeliveryDate());
            dateToQuantityForWarehouseAndItem.put(orderRequest.getDeliveryDate(),oldQuantity-itemRequest.getQuantity());
        }
    }

    public void isReservePossible(OrderRequest orderRequest) throws Exception {
        ItemTodateAndQuantityDetailForWarehouse = warehouseItemDateQuantityDetail.get(orderRequest.getWarehouseId());
        if (ItemTodateAndQuantityDetailForWarehouse == null) {
            throw new Exception("Not possible warehouse not exists");
        }

        for (ItemRequest itemRequest : orderRequest.getItems()) {
            dateToQuantityForWarehouseAndItem = ItemTodateAndQuantityDetailForWarehouse.get(itemRequest.getItem().getItemId());
            if (dateToQuantityForWarehouseAndItem == null) {
                throw new Exception("Not possible Item not exists");
            }

            if(dateToQuantityForWarehouseAndItem.containsKey(orderRequest.getDeliveryDate())){
                throw new Exception("Not possible Date not exists");
            }
            int quantity=dateToQuantityForWarehouseAndItem.get(orderRequest.getDeliveryDate());
            if(quantity<itemRequest.getQuantity()){
                throw new Exception("Not possible less quantity for "+itemRequest.getItem().getItemId());
            }
        }
    }

}
