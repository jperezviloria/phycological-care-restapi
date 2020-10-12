package com.psychologist.bookAppointment.service.implementation;

import com.psychologist.bookAppointment.model.Client;
import com.psychologist.bookAppointment.repository.ClientRepository;
import com.psychologist.bookAppointment.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImplementation implements IClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(String idClient) {
        return clientRepository.findById(idClient);
    }

    @Override
    public String saveClient(Client client) {
        clientRepository.save(client);
        return "Client saved";
    }

    @Override
    public void deleteClientById(String idClient) {
        clientRepository.deleteById(idClient);
    }
}
