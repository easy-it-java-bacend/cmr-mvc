package kg.easyit.crm.mapper;

import kg.easyit.crm.model.dto.CourseDto;
import kg.easyit.crm.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper extends BaseMapper<Course, CourseDto> {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
}
