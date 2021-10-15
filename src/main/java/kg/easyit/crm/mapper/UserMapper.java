package kg.easyit.crm.mapper;

import kg.easyit.crm.domain.dto.UserDTO;
import kg.easyit.crm.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDTO> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Override
    User toEntity(UserDTO userDTO);
}
