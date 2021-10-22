package kg.easyit.crm.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {

    Long id;

    String firstName;

    String lastName;

    String email;

    String phoneNumber;

    LocalDate dob;
}
