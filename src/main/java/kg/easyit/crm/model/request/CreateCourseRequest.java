package kg.easyit.crm.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCourseRequest {

    @NotBlank
    String courseName;

    @Min(value = 4)
    Integer classesPerMonth;

    @PositiveOrZero
    BigDecimal monthlyCost;

    @Positive
    Long courseTypeId;

}
