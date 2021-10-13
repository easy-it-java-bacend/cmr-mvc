package kg.easyit.crm.mapper;

import kg.easyit.crm.dto.ManagerDTO;
import kg.easyit.crm.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ManagerMapper extends BaseMapper<Manager, ManagerDTO> {

    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    @Override
    @Mapping(target = "user", ignore = true)
    Manager toEntity(ManagerDTO managerDTO);
}
