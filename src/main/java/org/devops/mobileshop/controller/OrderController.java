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

@CrossOrigin("*")
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

    @PostMapping("/accept-order/{deliverId}")

    public List<OrderResponseDto> accpetOrder(@PathVariable String deliverId , @RequestBody List<String> orderIds)

    {


         return orderService.acceptOrder(deliverId, orderIds);




    }

    @GetMapping("/{deliverId}")

    public  List<OrderResponseDto> getAllOrdersByDeliverId(  @PathVariable String  deliverId) {



         return orderService.getAllOrdersByDeliverId( deliverId);
    }
}
