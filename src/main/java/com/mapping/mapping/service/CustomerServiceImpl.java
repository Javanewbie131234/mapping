package com.mapping.mapping.service;

import com.mapping.mapping.Dto.CustomerDTO;
import com.mapping.mapping.Utility.CustomerUtil;
import com.mapping.mapping.entity.Customer;
import com.mapping.mapping.entity.Product;
import com.mapping.mapping.repository.CustomerRepository;
import com.mapping.mapping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public CustomerDTO saveOrder(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setEmailId(customerDTO.getEmailId());
        customer.setName(customerDTO.getName());
        Customer customerEntity = customerRepository.save(customer);
        if(customerDTO.getProduct()!=null){
            List<Product> productToadd = new ArrayList<>();
            for(Product product: customerDTO.getProduct()){
                Product addProduct = new Product();
                addProduct.setProductName(product.getProductName());
                addProduct.setPrice(product.getPrice());
                addProduct.setQuantity(product.getQuantity());
                productToadd.add(addProduct);

            }
            updateCustomerwithProduct(customerEntity.getId(),productToadd);

            }

            CustomerDTO saveDTO = CustomerUtil.convertToDTO(customerEntity);
            saveDTO.setProduct(null);
            return saveDTO;


    }

    public List<CustomerDTO> getAllCustomer(){
        return customerRepository.findAll().stream()
                .map(CustomerUtil::convertToDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO updateCustomerwithProduct(int id,List<Product> productToAdd){
        Customer customer = customerRepository.findById(id).orElseThrow();

        for(Product addProduct:productToAdd){
            addProduct.setCustomer(customer);
            productRepository.save(addProduct);

        }
//        customer.setProduct(productToAdd);
         return CustomerUtil.convertToDTO(customer);

    }

    public void deleteCustomer(int id){
        customerRepository.deleteById(id);
    }







}
