package org.devops.mobileshop.service;


import lombok.RequiredArgsConstructor;
import org.devops.mobileshop.dto.OrderDto;
import org.devops.mobileshop.dto.OrderResponseDto;
import org.devops.mobileshop.model.Order;
import org.devops.mobileshop.repository.OrderRepository;
import org.devops.mobileshop.repository.ProductsRepository;
import org.devops.mobileshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {

     private final OrderRepository orderRepository;


      private final UserRepository userRepository;

      private final ProductsRepository productsRepository;



        public OrderDto createOrder( OrderDto orderDto) {



              var createdOrder = new Order();

               // getting the user via id

             var user = userRepository.findUserById(orderDto.customerId())
;




              var  productList =  productsRepository.findByIdIn( orderDto.productIds());

              var shippingAddress = orderDto.shippingAddress();
              var billingAddress = orderDto.billingAddress();



              createdOrder.setUser(user);
              createdOrder.setStatus("PENDING");
              createdOrder.setProductList(productList);





              // sacing the order to the database
              orderRepository.insert(createdOrder);





                return new OrderDto(user.getName() ,user.getId(), shippingAddress, billingAddress ,orderDto.productIds());





        }



        public List<OrderResponseDto> getAllOrders() {



              return   orderRepository.findAll().stream().map( order -> new OrderResponseDto(
                      order.getUser().getName(),
                      order.getUser().getId(),
                      order.getShippingAddress(),
                      order.getBillingAddress(),
                      order.getProductList()


              )).toList();
        }





}
