package kg.easyit.crm.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MentorDto {

    Long id;

    String firstName;

    String lastName;

    String email;

    String phoneNumber;

    BigDecimal salary;

    List<SubjectDto> subjectDtos;
}
