package com.dias.he4rt_delas_remember.domain.DTO;

import java.time.LocalDate;

public record EventShowDTO(
        String eventName,
        String registeredBy,
        String eventOwner,
        LocalDate eventDeadline
) {
}
