package kg.easyit.crm.mapper;

import kg.easyit.crm.domain.dto.ManagerDto;
import kg.easyit.crm.domain.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ManagerMapper extends BaseMapper<Manager, ManagerDto> {

    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    @Override
    @Mapping(target = "user", ignore = true)
    Manager toEntity(ManagerDto managerDTO);
}
