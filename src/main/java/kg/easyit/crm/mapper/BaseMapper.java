package kg.easyit.crm.mapper;

import java.util.List;

public interface BaseMapper<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
    List<ENTITY> toEntityList(List<DTO> dtoList);
    List<DTO> toDtoList(List<ENTITY> entityList);
}
