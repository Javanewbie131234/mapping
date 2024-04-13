package com.mapping.mapping.Utility;

import com.mapping.mapping.Dto.CustomerDTO;
import com.mapping.mapping.entity.Customer;
import com.mapping.mapping.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomerUtil {

    public static Customer convertToEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setEmailId(customerDTO.getEmailId());
        if(customerDTO.getProduct()!=null){
            List<Product> products = new ArrayList<>();
            for(Product product : customerDTO.getProduct()){
               Product addProduct = new Product();
            addProduct.setProductId(product.getProductId());
            addProduct.setProductName(product.getProductName());
                addProduct.setPrice(product.getPrice());
                addProduct.setQuantity(product.getQuantity());
            products.add(addProduct);
            }

            customer.setProduct(products);
        }
        return  customer;

    }

    public static CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmailId(customer.getEmailId());
        if (customer.getProduct() != null) {
            List<Product> productsToAdd = new ArrayList<>();
            for (Product product : customer.getProduct()) {
                Product addProduct = new Product();
                addProduct.setProductId(product.getProductId());
                addProduct.setProductName(product.getProductName());
                addProduct.setPrice(product.getPrice());
                addProduct.setQuantity(product.getQuantity());
                productsToAdd.add(addProduct);
            }
            customerDTO.setProduct(productsToAdd);
        }

            return customerDTO;
        }


}
