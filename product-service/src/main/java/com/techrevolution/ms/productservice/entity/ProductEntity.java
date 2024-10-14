package com.techrevolution.ms.productservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("product")
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Getter
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
