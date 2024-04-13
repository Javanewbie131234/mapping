package com.mapping.mapping.Dto;

import com.mapping.mapping.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int productId;
    private String productName;
    private int quantity;
    private int price;

    private Customer customer;
}
