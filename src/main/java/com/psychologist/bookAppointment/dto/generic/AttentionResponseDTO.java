package com.psychologist.bookAppointment.dto.generic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AttentionResponseDTO {

    private String messageAttention;

    public AttentionResponseDTO(String messageAttention) {
        this.messageAttention = messageAttention;
    }
}
