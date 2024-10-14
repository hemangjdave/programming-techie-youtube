package com.techrevolution.ms.orderservice.service;

import com.techrevolution.ms.orderservice.clients.InventoryClient;
import com.techrevolution.ms.orderservice.dto.OrderRequest;
import com.techrevolution.ms.orderservice.dto.OrderResponse;
import com.techrevolution.ms.orderservice.entity.Order;
import com.techrevolution.ms.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Integer quantity = orderRequest.quantity();
        String skuCode = orderRequest.skuCode();
        if (inventoryClient.isInStock(skuCode, quantity)) {
            Order order = new Order();
            String orderNumber = UUID.randomUUID().toString();
            order.setOrderNumber(orderNumber);
            order.setQuantity(quantity);
            order.setPrice(orderRequest.price());
            order.setSkuCode(skuCode);
            orderRepository.save(order);
            return new OrderResponse(
                    HttpStatus.CREATED.value(),
                    orderNumber,
                    skuCode,
                    orderRequest.price(),
                    quantity
            );
        } else {
            throw new RuntimeException("Inventory is full");
        }
    }

}
