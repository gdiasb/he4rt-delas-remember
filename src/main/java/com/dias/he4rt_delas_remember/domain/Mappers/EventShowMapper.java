package com.dias.he4rt_delas_remember.domain.Mappers;

import com.dias.he4rt_delas_remember.domain.DTO.EventShowDTO;
import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventShowMapper {

    EventShowMapper INSTANCE = Mappers.getMapper(EventShowMapper.class);

    EventShowDTO toEventShowDTO(EventEntity eventEntity);

}
