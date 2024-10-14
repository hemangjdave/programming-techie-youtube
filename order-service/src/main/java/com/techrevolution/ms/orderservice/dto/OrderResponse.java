package com.techrevolution.ms.orderservice.dto;

import java.math.BigDecimal;

public record OrderResponse(int statusCode , String orderNumber , String skuCode , BigDecimal price , Integer quantity) {
}
