package kg.easyit.crm.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupDto {

    Long id;

    String groupName;

    CourseDto courseDto;

    MentorDto mentorDto;

    LocalDateTime classTime;

    List<StudentDto> studentsOfGroup;
}
