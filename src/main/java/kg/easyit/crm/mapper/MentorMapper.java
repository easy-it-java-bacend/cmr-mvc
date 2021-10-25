package kg.easyit.crm.mapper;

import kg.easyit.crm.model.dto.MentorDto;
import kg.easyit.crm.model.entity.Mentor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MentorMapper extends BaseMapper<Mentor, MentorDto> {
    MentorMapper INSTANCE = Mappers.getMapper(MentorMapper.class);
}
