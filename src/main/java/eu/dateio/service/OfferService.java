package eu.dateio.service;

import eu.dateio.dao.OfferRepository;
import eu.dateio.exceptions.NotFoundException;
import eu.dateio.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {
    private final OfferRepository dao;

    @Autowired
    public OfferService(OfferRepository dao) {
        this.dao = dao;
    }

    /**
     * Find offer by id
     * @param offerId - id of offer
     * @return offer with offerId
     */
    public Offer findOfferById(Integer offerId) {
        Optional<Offer> optOffer = dao.findById(offerId);
        if (optOffer.isPresent()) {
            return optOffer.get();
        }
        throw NotFoundException.create("Offer", offerId);
    }
}
