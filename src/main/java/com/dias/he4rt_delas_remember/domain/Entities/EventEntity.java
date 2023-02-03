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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private String createdBy = "Gabriela";

    @Column(name = "created_on")
    private LocalDate createdOn = LocalDate.now();

    private String name;

    private boolean status = false;

    private String owner;

    @Enumerated(value = EnumType.STRING)
    private CATEGORIES category;

    private LocalDate deadline;

    private String description;

    private String url;

    public EventEntity() {
    }

    public EventEntity(Long id, String createdBy, LocalDate createdOn, String name, boolean status, String owner, CATEGORIES category, LocalDate deadline, String description, String url) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.name = name;
        this.status = status;
        this.owner = owner;
        this.category = category;
        this.deadline = deadline;
        this.description = description;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public CATEGORIES getCategory() {
        return category;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCategory(CATEGORIES category) {
        this.category = category;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
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
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", createdOn=").append(createdOn);
        sb.append(", name='").append(name).append('\'');
        sb.append(", status=").append(status);
        sb.append(", owner='").append(owner).append('\'');
        sb.append(", category=").append(category);
        sb.append(", deadline=").append(deadline);
        sb.append(", description='").append(description).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
