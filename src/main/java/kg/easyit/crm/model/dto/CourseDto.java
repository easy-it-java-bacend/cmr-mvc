package kg.easyit.crm.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDto {

    Long id;

    String courseName;

    Integer classesPerMonth;

    BigDecimal monthlyCost;

    CourseTypeDto courseTypeDto;

}
