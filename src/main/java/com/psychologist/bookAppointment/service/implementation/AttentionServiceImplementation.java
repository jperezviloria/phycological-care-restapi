package com.psychologist.bookAppointment.service.implementation;

import com.psychologist.bookAppointment.model.Attention;
import com.psychologist.bookAppointment.repository.AttentionRepository;
import com.psychologist.bookAppointment.service.IAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class AttentionServiceImplementation implements IAttentionService {

    @Autowired
    AttentionRepository attentionRepository;

    public List<Attention> getAttentions(){
        return attentionRepository.findAll();
    }

    @Override
    public void saveAttention(Attention attention) {
        attentionRepository.save(attention);
    }

    @Override
    public void updateAttention(String idAttention, String imageLinkAttention) {
         Optional<Attention> oldAttention = attentionRepository.findById(idAttention);
         oldAttention.get().setImageLinkAttention(imageLinkAttention);
         attentionRepository.save(oldAttention.get());
    }


}
