package com.mapping.mapping.service;

import com.mapping.mapping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {

    @Autowired
    ProductRepository productRepository;

}
