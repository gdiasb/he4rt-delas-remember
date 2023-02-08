package com.dias.he4rt_delas_remember.repositories;

import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    @Transactional
    @Modifying
    @Query("update EventEntity " +
            "set status = false where status = true and deadline <= " +
            ":deadline")
    void updateActiveEvents(@Param("deadline") LocalDateTime deadline);
}
