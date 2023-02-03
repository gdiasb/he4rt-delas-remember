package com.dias.he4rt_delas_remember.domain.DTO;

import com.dias.he4rt_delas_remember.domain.Entities.CATEGORIES;

import java.time.LocalDate;

public record EventRegisterDTO(
        String name,
        String owner,
        CATEGORIES category,
        LocalDate deadline,
        String description,
        String url
) {
}
