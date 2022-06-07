package eu.dateio.model;

import eu.dateio.dto.UserBehaviourDto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.OffsetDateTime;

@Entity
public class UserBehaviour {
    @EmbeddedId
    private UserBehaviourId userBehaviourId;
    @Column(columnDefinition = "boolean default false")
    private boolean isOfferActive;
    @Column(columnDefinition = "boolean default false")
    private boolean isOfferSeen;
    private OffsetDateTime lastSeen;

    public UserBehaviour(){}

    public UserBehaviour(UserBehaviourDto dto, Client client, Offer offer) {
        this.userBehaviourId = new UserBehaviourId(client, offer);
        this.isOfferActive = dto.getIsOfferActive();
        this.isOfferSeen = dto.getIsOfferSeen();
        this.lastSeen = dto.getLastSeen();
    }

    public UserBehaviourId getUserBehaviourId() {
        return userBehaviourId;
    }

    public void setUserBehaviourId(UserBehaviourId userBehaviourId) {
        this.userBehaviourId = userBehaviourId;
    }

    public boolean isOfferActive() {
        return isOfferActive;
    }

    public void setOfferActive(boolean offerActive) {
        isOfferActive = offerActive;
    }

    public boolean isOfferSeen() {
        return isOfferSeen;
    }

    public void setOfferSeen(boolean offerSeen) {
        isOfferSeen = offerSeen;
    }

    public OffsetDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(OffsetDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

}
