package org.devops.mobileshop.repository;


import org.devops.mobileshop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductsRepository extends MongoRepository<Product, String> {


}
