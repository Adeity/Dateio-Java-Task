package eu.dateio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class Client extends AbstractEntity{
    @Column(name = "bank_id")
    private Long bankId;

    @Column(unique = true)
    private String uuid;

    @Column(name = "registration_time")
    private OffsetDateTime registrationTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return bankId.equals(client.bankId) && uuid.equals(client.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bankId, uuid);
    }
}