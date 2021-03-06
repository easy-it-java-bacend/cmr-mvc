package kg.easyit.crm.mapper;

import kg.easyit.crm.model.dto.StudentDto;
import kg.easyit.crm.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper extends BaseMapper<Student, StudentDto> {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
}
