package com.psychologist.bookAppointment.service.implementation;

import com.psychologist.bookAppointment.model.Client;
import com.psychologist.bookAppointment.repository.ClientRepository;
import com.psychologist.bookAppointment.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Client> getTrueClients(Boolean resolveCLient) {
        return clientRepository.getTrueClient(resolveCLient);
    }

    @Override
    public Optional<Client> getClientById(String idClient) {
        return clientRepository.findById(idClient);
    }

    @Override
    public String saveClient(Client client) {
        if(client.isResolvedClient()){
            client.setResolvedClient(false);
        }
        clientRepository.save(client);
        return "Client saved";
    }

    @Override
    public void deleteClientById(String idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    public String changeStatusById(String idClient) {
        Optional<Client> particularClient = clientRepository.findById(idClient);
        if(particularClient.get().isResolvedClient() == true){
            particularClient.get().setResolvedClient(false);
            clientRepository.save(particularClient.get());
            return "from true to false";
        }
        if(particularClient.get().isResolvedClient() == false){
            particularClient.get().setResolvedClient(true);
            clientRepository.save(particularClient.get());
            return "from false to true";
        }
        return "dont change anything";
    }
}
