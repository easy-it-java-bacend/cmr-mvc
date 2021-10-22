package kg.easyit.crm.mapper;

import kg.easyit.crm.domain.dto.UserDto;
import kg.easyit.crm.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Override
    User toEntity(UserDto userDTO);
}
