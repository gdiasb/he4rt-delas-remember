package com.dias.he4rt_delas_remember.domain.DTO;

import com.dias.he4rt_delas_remember.domain.Entities.CATEGORIES;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.dias.he4rt_delas_remember.domain.Entities.EventEntity} entity
 */
public record EventEntityDtoJPABuddy(String eventName, String eventOwner, CATEGORIES eventCategory,
                                     LocalDate eventDeadline,
                                     String eventDescription) implements Serializable {
}