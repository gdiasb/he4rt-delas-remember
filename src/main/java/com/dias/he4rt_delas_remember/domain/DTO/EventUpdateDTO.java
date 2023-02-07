package com.dias.he4rt_delas_remember.domain.DTO;

import java.time.LocalDateTime;

public record EventUpdateDTO(
        String name,
        LocalDateTime deadline,
        String description,
        String url
) {
}
