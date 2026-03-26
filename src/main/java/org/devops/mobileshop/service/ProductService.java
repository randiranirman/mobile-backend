package org.devops.mobileshop.service;


import lombok.RequiredArgsConstructor;
import org.devops.mobileshop.dto.ProductDto;
import org.devops.mobileshop.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor

public class ProductService {

    private final ProductsRepository productsRepository;

    public List<ProductDto> getAllProducts() {


        return productsRepository.findAll().stream().map( product -> new ProductDto(product.getId(), product.getModel(),
                product.getPrice(),
                product.getQuantity(),product.getDescription(),product.getImage())).collect(Collectors.toList());
    }
}
