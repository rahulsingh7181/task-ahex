package com.rahul.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MagicalProduct {
    private Long productId;
    private String productCode;
    private String productName;
    private Double productPrice;
    private Boolean magicalProduct;
}
