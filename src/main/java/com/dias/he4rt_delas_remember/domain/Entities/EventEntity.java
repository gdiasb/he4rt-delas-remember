package com.dias.he4rt_delas_remember.domain.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "registered_by")
    private String registeredBy;

    @Column(name = "name")
    private String eventName;

    @Column(name = "owner")
    private String eventOwner;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private CATEGORIES eventCategory;

    @Column(name = "deadline")
    private LocalDate eventDeadline;

    @Column(name = "description")
    private String eventDescription;

    public EventEntity() {
    }

    public EventEntity(Long id, String registeredBy, String eventName, String eventOwner, CATEGORIES eventCategory, LocalDate eventDeadline, String eventDescription) {
        this.id = id;
        this.registeredBy = registeredBy;
        this.eventName = eventName;
        this.eventOwner = eventOwner;
        this.eventCategory = eventCategory;
        this.eventDeadline = eventDeadline;
        this.eventDescription = eventDescription;
    }

    public Long getId() {
        return id;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventOwner() {
        return eventOwner;
    }

    public CATEGORIES getEventCategory() {
        return eventCategory;
    }

    public LocalDate getEventDeadline() {
        return eventDeadline;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventEntity that)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventEntity{");
        sb.append("id=").append(id);
        sb.append(", registeredBy='").append(registeredBy).append('\'');
        sb.append(", eventName='").append(eventName).append('\'');
        sb.append(", eventOwner='").append(eventOwner).append('\'');
        sb.append(", eventCategory=").append(eventCategory);
        sb.append(", eventDeadline=").append(eventDeadline);
        sb.append(", eventDescription='").append(eventDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
