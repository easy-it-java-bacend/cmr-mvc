package kg.easyit.crm.mapper;

import kg.easyit.crm.model.dto.UserDto;
import kg.easyit.crm.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
