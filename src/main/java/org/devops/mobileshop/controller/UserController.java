package org.devops.mobileshop.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.devops.mobileshop.dto.UserDto;
import org.devops.mobileshop.service.DeliverService;
import org.devops.mobileshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/user")

@RequiredArgsConstructor

public class UserController {


    private final UserService userService;

    private final DeliverService deliverService;



    @PostMapping
     public UserDto createUser(@RequestBody UserDto request) {

         return userService.createUser(request);

     }

     @PostMapping("/deliver")
    public UserDto createDeliver( @RequestBody UserDto request) {


        return  deliverService.createDeliver(request);
     }


     @GetMapping("/deliver/all")
    public List<UserDto> getAllDelivers( ) {


         return deliverService.getAllDelivers();
     }



}
