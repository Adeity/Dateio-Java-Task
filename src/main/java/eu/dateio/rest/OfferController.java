package eu.dateio.rest;

import eu.dateio.model.Offer;
import eu.dateio.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/offer")
public class OfferController {
    private final OfferService service;

    @Autowired
    public OfferController(OfferService service) {
        this.service = service;
    }

    /**
     * READ offer by its id
     * @param offerId - id of offer
     * @return offer with  offerId
     */
    @GetMapping(value = "/{offerId}")
    public Offer getOfferById(@PathVariable Integer offerId) {
        Objects.requireNonNull(offerId);
        return service.findOfferById(offerId);
    }
}
