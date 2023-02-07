package com.dias.he4rt_delas_remember.domain.Mappers;

import com.dias.he4rt_delas_remember.domain.DTO.EventRegisterDTO;
import com.dias.he4rt_delas_remember.domain.DTO.EventShowDTO;
import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventShowDTO toEventShowDTO(EventEntity eventEntity);

    EventEntity toEventEntity(EventRegisterDTO eventRegisterDTO);

}
