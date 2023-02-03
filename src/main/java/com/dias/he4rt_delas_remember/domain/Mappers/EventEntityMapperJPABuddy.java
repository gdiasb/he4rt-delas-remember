package com.dias.he4rt_delas_remember.domain.Mappers;

import com.dias.he4rt_delas_remember.domain.DTO.EventEntityDtoJPABuddy;
import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EventEntityMapperJPABuddy {
    EventEntity toEntity(EventEntityDtoJPABuddy eventEntityDto);

    EventEntityDtoJPABuddy toDto(EventEntity eventEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EventEntity partialUpdate(EventEntityDtoJPABuddy eventEntityDto, @MappingTarget EventEntity eventEntity);
}