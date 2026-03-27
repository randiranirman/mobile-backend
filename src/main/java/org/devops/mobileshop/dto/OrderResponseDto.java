package org.devops.mobileshop.dto;

import org.devops.mobileshop.model.Product;

import java.util.List;

public record OrderResponseDto(String customerName, String customerId    , String  shippingAddress , String billingAddress , List<Product> productList) {
}
