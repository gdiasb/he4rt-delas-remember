package com.dias.he4rt_delas_remember.repositories;

import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
