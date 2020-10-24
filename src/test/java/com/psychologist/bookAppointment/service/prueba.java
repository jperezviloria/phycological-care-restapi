package com.psychologist.bookAppointment.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class prueba {

    @Test
    void palabras_test(){
        String[] palabras = {"papelon", "sol", "hablando","cama","Miel", "Alba"};
        for(String particularPalabra: palabras){
            if(particularPalabra.length() <= 4)
            System.out.println(particularPalabra);
        }
    }

    @Test
    void anios(){
        String anio = "2020";
        System.out.println(anio.substring(2));
    }
}
