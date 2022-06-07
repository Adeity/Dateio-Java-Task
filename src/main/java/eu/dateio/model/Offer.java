package eu.dateio.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class Offer extends AbstractEntity{
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "visible_from")
    private OffsetDateTime visibleFrom;

    @Column(name = "visible_to")
    private OffsetDateTime visibleTo;

    @Column(name = "description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getVisibleFrom() {
        return visibleFrom;
    }

    public void setVisibleFrom(OffsetDateTime visibleFrom) {
        this.visibleFrom = visibleFrom;
    }

    public OffsetDateTime getVisibleTo() {
        return visibleTo;
    }

    public void setVisibleTo(OffsetDateTime visibleTo) {
        this.visibleTo = visibleTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Offer offer = (Offer) o;
        return Objects.equals(name, offer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
