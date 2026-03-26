package org.devops.mobileshop.repository;


import org.devops.mobileshop.model.Deliver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliverRepository  extends MongoRepository<Deliver, String> {


}
