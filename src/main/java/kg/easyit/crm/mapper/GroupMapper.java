package kg.easyit.crm.mapper;

import kg.easyit.crm.model.dto.GroupDto;
import kg.easyit.crm.model.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper extends BaseMapper<Group, GroupDto> {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);
}
