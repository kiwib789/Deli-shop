package com.pluralsight.deli.service;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Product;
import com.pluralsight.deli.receipt.ReceiptManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderServiceImpl implements OrderService {

    @Override
    public void addProductToOrder(Order order, Product product){
        order.addProduct(product);

    }

    @Override
    public Order createNewOrder(String customerName){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        String orderID = today.format(formattedDate);
        return new Order(orderID, customerName);
    }

    @Override
    public void checkOut(Order order){
        ReceiptManager receiptManager = new ReceiptManager();
        receiptManager.receipt(order);
    }

    @Override
    public double totalPrice(Order order) {
        double totalPrice = 0.0;
        for (Product item : order.getProductsList()){
            totalPrice += item.getPrice();
        }
        return totalPrice;

    }


}
