package com.dias.he4rt_delas_remember.domain.DTO;

import com.dias.he4rt_delas_remember.domain.Entities.CATEGORIES;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

public record EventRegisterDTO(

        @NotBlank
        String name,

        @NotBlank
        String owner,

        @NotNull
        CATEGORIES category,

        @NotNull @Future
        LocalDateTime deadline,

        @NotBlank
        String description,

        @NotBlank @URL
        String url
) {
}
