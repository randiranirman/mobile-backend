package org.devops.mobileshop.controller;


import lombok.RequiredArgsConstructor;
import org.devops.mobileshop.dto.OrderDto;
import org.devops.mobileshop.dto.OrderResponseDto;
import org.devops.mobileshop.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor

public class OrderController {


    private final OrderService orderService;




    @PostMapping


     public OrderDto placeOrder(@RequestBody OrderDto orderDto){

        return  orderService.createOrder(orderDto);





    }


    @GetMapping
    public List<OrderResponseDto> getAllOrders( ) {

        return  orderService.getAllOrders()
                ;
    }
}
