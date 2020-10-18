package com.psychologist.bookAppointment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "client")
public class Client {

    @Id
    private String idClient;
    private String nameClient;
    private int yearsClient;
    private String contactMethod;
    //@JsonFormat(pattern="dd/MM/yyyy")
    private int bookAppointmentCost;


    private boolean resolvedClient;
}
