package com.mapping.mapping.Utility;

import com.mapping.mapping.Dto.ProductDTO;
import com.mapping.mapping.entity.Product;

public class ProductUtil {

    public static ProductDTO convertToDTO(Product product){
        ProductDTO productDTO = new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getQuantity(),
                product.getPrice(),
                product.getCustomer()
        );
        return productDTO;

    }

    public static Product convertToentity(ProductDTO productDTO){
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setCustomer(productDTO.getCustomer());
        return product;

    }



}
