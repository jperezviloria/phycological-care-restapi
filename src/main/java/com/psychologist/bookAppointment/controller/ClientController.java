package com.psychologist.bookAppointment.controller;

import com.psychologist.bookAppointment.dto.generic.RestResponse;
import com.psychologist.bookAppointment.model.Client;
import com.psychologist.bookAppointment.service.implementation.ClientServiceImplementation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/client")
public class ClientController {

    //private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientServiceImplementation clientServiceImplementation;

    @GetMapping("/getall_clients")
    public List<Client> getAllClients(){
        return clientServiceImplementation.getAllClients();
    }
//    public RestResponse<List<Client>> getAllClients(){
//        List<Client> clientList = new ArrayList<>();
//        HttpStatus httpStatus = HttpStatus.PRECONDITION_FAILED;
//        try {
//            clientList = clientServiceImplementation.getAllClients();
//            if (!clientList.isEmpty()) {
//                httpStatus = HttpStatus.OK;
//            } else {
//                httpStatus = HttpStatus.NO_CONTENT;
//            }
//        } finally {
//
//        }
//        return new RestResponse<List<Client>>(httpStatus, clientList);
//        }

    @PostMapping("/save_client")
    public String saveClient (@RequestBody Client client){
        return clientServiceImplementation.saveClient(client);
    }
//    public RestResponse<Client> saveClient(@RequestBody Client client){
//        HttpStatus httpStatus = HttpStatus.PRECONDITION_FAILED;
//        Client savedClient = clientServiceImplementation.saveClient(client);
//        httpStatus = HttpStatus.OK;
//        return new RestResponse<>(httpStatus, savedClient);
//    }
}


