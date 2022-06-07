package eu.dateio.dto;

import java.time.OffsetDateTime;

public class UserBehaviourDto {
    private Integer clientId;
    private Integer offerId;
    private Boolean isOfferActive;
    private Boolean isOfferSeen;
    private OffsetDateTime lastSeen;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Boolean getIsOfferActive() {
        return isOfferActive;
    }

    public void setIsOfferActive(Boolean offerActive) {
        isOfferActive = offerActive;
    }

    public Boolean getIsOfferSeen() {
        return isOfferSeen;
    }

    public void setIsOfferSeen(Boolean offerSeen) {
        isOfferSeen = offerSeen;
    }

    public OffsetDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(OffsetDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }
}
