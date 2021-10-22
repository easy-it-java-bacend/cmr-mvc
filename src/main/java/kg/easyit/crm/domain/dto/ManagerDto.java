package kg.easyit.crm.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManagerDto {

    Long id;

    String firstName;
    String lastName;
    String phoneNumber;
    String email;

}
