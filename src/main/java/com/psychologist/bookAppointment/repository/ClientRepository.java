package com.psychologist.bookAppointment.repository;

import com.psychologist.bookAppointment.model.Attention;
import com.psychologist.bookAppointment.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    @Query(value = "{'resolvedClient' : ?0}")
    List<Client> getTrueClient(Boolean resolvedClient);

}
