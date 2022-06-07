package eu.dateio.service;

import eu.dateio.dao.ClientRepository;
import eu.dateio.dao.OfferRepository;
import eu.dateio.exceptions.NotFoundException;
import eu.dateio.model.Client;
import eu.dateio.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository dao;

    @Autowired
    public ClientService(ClientRepository dao) {
        this.dao = dao;
    }

    /**
     * Finds client by id
     * @param clientId - id of client
     * @return Client with clientId
     */
    public Client findClientById(Integer clientId) {
        Optional<Client> optionalClient = dao.findById(clientId);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        }
        throw NotFoundException.create("Client", clientId);
    }
}
