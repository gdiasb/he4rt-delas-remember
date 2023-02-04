package com.dias.he4rt_delas_remember.domain.DTO;

import com.dias.he4rt_delas_remember.domain.Entities.CATEGORIES;

import java.time.LocalDateTime;

public record EventShowDTO(
        String name,
        String createdBy,
        String owner,
        CATEGORIES category,
        LocalDateTime deadline,
        String description,
        String url
) {
}
