package com.psychologist.bookAppointment.controller;

import com.psychologist.bookAppointment.dto.generic.RestResponse;
import com.psychologist.bookAppointment.model.Attention;
import com.psychologist.bookAppointment.model.Client;
import com.psychologist.bookAppointment.service.implementation.ClientServiceImplementation;
import com.psychologist.bookAppointment.service.implementation.SmtpMailSerderImplementation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/client")
public class ClientController {

    //private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientServiceImplementation clientServiceImplementation;

    @Autowired
    SmtpMailSerderImplementation smtpMailSerderImplementation;

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

    @GetMapping("/boolean")
    public List<Client> getTrueClient(){
        return clientServiceImplementation.getTrueClients(false);
    }

    @GetMapping("/email")
    public void sendMail() throws MessagingException, UnsupportedEncodingException {
        smtpMailSerderImplementation.send("perezjulioernesto@gmail.com","Este es el subject", "este es el body");
    }

    @PostMapping("/email")
    public void sendMailPost(@RequestBody Client client) throws MessagingException, UnsupportedEncodingException {
        smtpMailSerderImplementation.send(client.getNameClient(),"Este es el subject", "este es el body"+client.getContactMethod()+client.getYearsClient()+client.isResolvedClient()+client.getBookAppointmentCost());
    }

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

        @GetMapping("/change_status/{idClient}")
    public String changeStatus (@PathVariable String idClient){
        return clientServiceImplementation.changeStatusById(idClient);

    }
}


