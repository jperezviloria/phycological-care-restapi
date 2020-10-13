package com.psychologist.bookAppointment.repository;

import com.psychologist.bookAppointment.model.Attention;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttentionRepository extends MongoRepository<Attention, String> {
}
