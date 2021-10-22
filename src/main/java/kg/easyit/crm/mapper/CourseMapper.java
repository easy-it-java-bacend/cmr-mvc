package kg.easyit.crm.mapper;

import kg.easyit.crm.domain.dto.CourseDto;
import kg.easyit.crm.domain.entity.Course;
import org.mapstruct.factory.Mappers;

public interface CourseMapper extends BaseMapper<Course, CourseDto> {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
}
