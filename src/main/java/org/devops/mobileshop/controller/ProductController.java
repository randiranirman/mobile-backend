package org.devops.mobileshop.controller;


import lombok.RequiredArgsConstructor;
import org.devops.mobileshop.dto.ProductDto;
//import org.devops.mobileshop.repository.ProductsRepository;
import org.devops.mobileshop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product"
)
@RequiredArgsConstructor
public class ProductController {





    private final ProductService productService;



    @GetMapping
    public List<ProductDto> getAllProducts( ){

        return productService.getAllProducts();


    }



}
