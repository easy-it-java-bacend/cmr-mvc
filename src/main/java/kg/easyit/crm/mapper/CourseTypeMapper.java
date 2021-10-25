package kg.easyit.crm.mapper;

import kg.easyit.crm.model.dto.CourseTypeDto;
import kg.easyit.crm.model.entity.CourseType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseTypeMapper extends BaseMapper<CourseType, CourseTypeDto> {

    CourseTypeMapper INSTANCE = Mappers.getMapper(CourseTypeMapper.class);

}
