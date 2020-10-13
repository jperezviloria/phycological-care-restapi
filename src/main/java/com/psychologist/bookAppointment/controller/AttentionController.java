package com.psychologist.bookAppointment.controller;

import com.psychologist.bookAppointment.dto.generic.AttentionResponseDTO;
import com.psychologist.bookAppointment.model.Attention;
import com.psychologist.bookAppointment.service.implementation.AttentionServiceImplementation;
import com.psychologist.bookAppointment.service.implementation.CloudinaryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attention")
@CrossOrigin("*")
public class AttentionController {

    @Autowired
    AttentionServiceImplementation attentionServiceImplementation;

    @Autowired
    CloudinaryServiceImplementation cloudinaryServiceImplementation;

    @GetMapping("/get_attention")
    public List<Attention> getAllAttention(){
        return attentionServiceImplementation.getAttentions();
    }

    @PostMapping("/create")
    public String addAttention(@RequestBody Attention attention){
        attentionServiceImplementation.saveAttention(attention);
        return "saved";
    }

    @PostMapping(
            path = "{idAttention}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadWork(@RequestParam("file") MultipartFile file,
                                        @PathVariable("idAttention") String idAttention) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        if(bufferedImage == null){
            return new ResponseEntity(new AttentionResponseDTO("Invalid Image"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryServiceImplementation.upload(file);
        String imageUrl = (String) result.get("url");
        attentionServiceImplementation.updateAttention(idAttention, imageUrl);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
