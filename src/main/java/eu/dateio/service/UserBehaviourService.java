package eu.dateio.service;

import eu.dateio.dao.UserBehaviourRepository;
import eu.dateio.dto.UserBehaviourDto;
import eu.dateio.exceptions.InvalidDtoException;
import eu.dateio.model.Client;
import eu.dateio.model.Offer;
import eu.dateio.model.UserBehaviour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class UserBehaviourService {
    private final UserBehaviourRepository dao;
    private final ClientService clientService;
    private final OfferService offerService;

    @Autowired
    public UserBehaviourService(UserBehaviourRepository dao, ClientService clientService, OfferService offerService) {
        this.dao = dao;
        this.clientService = clientService;
        this.offerService = offerService;
    }

    /**
     * Processes UserbehaviourDTO and saves it to the DB if it is valid
     * @param dto - UserBehaviourDto
     */
    @Transactional
    public void processDto(UserBehaviourDto dto) {
        isDtoValid(dto);
        Client client = clientService.findClientById(dto.getClientId());
        Offer offer = offerService.getOfferById(dto.getOfferId());
        if (client == null || offer == null) {
            throw new InvalidDtoException("Invalid user behaviour DTO");
        }
        UserBehaviour userBehaviour = new UserBehaviour(dto, client, offer);
        dao.save(userBehaviour);
    }

    private void isDtoValid(UserBehaviourDto dto) {
        try {
            Objects.requireNonNull(dto.getClientId());
            Objects.requireNonNull(dto.getOfferId());
            Objects.requireNonNull(dto.getIsOfferActive());
            Objects.requireNonNull(dto.getIsOfferSeen());
            Objects.requireNonNull(dto.getLastSeen());
        } catch (NullPointerException e) {
            throw InvalidDtoException.create();
        }
    }
}
