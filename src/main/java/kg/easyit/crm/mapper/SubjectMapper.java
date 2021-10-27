package kg.easyit.crm.mapper;

import kg.easyit.crm.model.dto.SubjectDto;
import kg.easyit.crm.model.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject, SubjectDto> {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);
}
