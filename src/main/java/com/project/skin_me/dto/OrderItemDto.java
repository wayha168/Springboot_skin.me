package com.project.skin_me.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {

    private Long productId;
    private String productName;
    private String productBrand;
    private String productType;
    private int quantity;
    private BigDecimal price;
    private double discount;

}
