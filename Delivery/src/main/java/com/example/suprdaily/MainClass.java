package com.example.suprdaily;

import com.example.suprdaily.controller.OrderController;
import com.example.suprdaily.model.Item;
import com.example.suprdaily.model.ItemRequest;
import com.example.suprdaily.model.OrderRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MainClass{
    public static void main(String args[]){
        SpringApplication.run(MainClass.class, args);
    }


    public static void main1(String args[]) {
        Scanner sc=new Scanner(System.in);
        OrderController orderController=new OrderController();
        while (true) {
            System.out.print("Write 1 for inserting data");
            System.out.print("Write 2 for checking fulfillment");
            System.out.print("Write 3 for reserve order");
            System.out.print("Write 4  for exit");

            int choice= sc.nextInt();
            OrderRequest orderRequest=new OrderRequest();
            if(choice!=4){
                orderRequest= getOrderRequest(sc);
            }
            switch( choice){
                case 1:
                    orderController.insertOrder(orderRequest);
                    break;
                case 2:
                    System.out.println(orderController.canFulfil(orderRequest));
                    break;
                case 3:
                    System.out.println(orderController.reserveOrder(orderRequest));
                    break;
                case 4:
                    return;
            }

        }
    }
    public static OrderRequest getOrderRequest(Scanner sc){
       OrderRequest orderRequest=new OrderRequest();
       orderRequest.setCustomerId(sc.nextLine());
       orderRequest.setDeliveryDate(sc.nextLine());
       orderRequest.setWarehouseId(sc.nextLine());

       List<ItemRequest> items=getItems(sc);
       orderRequest.setItems(items);
       return orderRequest;
    }

    static List<ItemRequest> getItems(Scanner sc) {
        List<ItemRequest> items = new ArrayList<ItemRequest>();
        while (true) {
            System.out.print("Write 1 for inserting more items");
            System.out.print("Write 2 to stop");
            int choice = sc.nextInt();
            if (choice == 2)
                break;
            else if (choice == 1) {
                ItemRequest itemRequest = new ItemRequest();
                Item item = new Item();
                item.setItemId(sc.nextInt());
                item.setItemName(sc.nextLine());
                item.setCategory(sc.nextLine());
                itemRequest.setItem(item);
                itemRequest.setQuantity(sc.nextInt());
                items.add(itemRequest);
            }
        }
        return items;
    }
}