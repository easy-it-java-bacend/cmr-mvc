package kg.easyit.crm.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCourseRequest {

    String courseName;

    Integer classesPerMonth;

    BigDecimal monthlyCost;

    Long courseTypeId;

}
