package kg.easyit.crm.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManagerDTO {

    String firstName;
    String lastName;
    String phoneNumber;
    String email;

}
