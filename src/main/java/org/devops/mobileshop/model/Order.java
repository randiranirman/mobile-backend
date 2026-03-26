package org.devops.mobileshop.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {



    @Id
    private String id ;

}
