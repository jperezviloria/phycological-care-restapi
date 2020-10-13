package com.psychologist.bookAppointment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "attention")
public class Attention {

    @Id
    private String idAttention;
    private String nameAttention;
    private String imageLinkAttention;

}
