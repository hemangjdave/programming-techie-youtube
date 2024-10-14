package com.techrevolution.ms.orderservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "t_orders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_number", columnDefinition = "varchar(255) default null")
    private String orderNumber;
    @Column(name = "sku_code", columnDefinition = "varchar(255)")
    private String skuCode;
    @Column(name = "price", columnDefinition = "decimal(19, 2)")
    private BigDecimal price;
    @Column(name = "quantity", columnDefinition = "int(11)")
    private Integer quantity;
}
