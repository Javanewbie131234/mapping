package com.mapping.mapping.Dto;

import com.mapping.mapping.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO  {
    int id;
    String name;
    String emailId;
    List<Product> product;
}
