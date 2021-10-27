package kg.easyit.crm.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateMentorRequest {

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @Email
    String email;

    @Size(min = 10, max = 13, message = "Phone number format is like 0500112233 or +996500112233")
    String phoneNumber;

    @PositiveOrZero
    BigDecimal salary;

    @NotNull
    List<Long> subjectsIds;
}
