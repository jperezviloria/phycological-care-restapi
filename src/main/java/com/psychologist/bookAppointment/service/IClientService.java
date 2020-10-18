package com.psychologist.bookAppointment.service;

import com.psychologist.bookAppointment.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    List<Client> getAllClients();

    List<Client> getTrueClients(Boolean resolveClient);

    Optional<Client> getClientById(String idClient);

    String saveClient(Client client);

    void deleteClientById(String idClient);

    String changeStatusById(String idClient);



}
