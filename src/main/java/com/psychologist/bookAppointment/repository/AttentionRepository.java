package com.psychologist.bookAppointment.repository;

import com.psychologist.bookAppointment.model.Attention;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttentionRepository extends MongoRepository<Attention, String> {
}

