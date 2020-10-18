package com.psychologist.bookAppointment.service;

import com.psychologist.bookAppointment.model.Attention;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IAttentionService {

    List<Attention> getAttentions();



    void saveAttention(Attention attention);

    void updateAttention(String idAttention, String imageLinkAttention);
}
