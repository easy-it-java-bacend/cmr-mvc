package kg.easyit.crm.mapper;

import kg.easyit.crm.model.dto.ManagerDto;
import kg.easyit.crm.model.entity.Manager;
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
