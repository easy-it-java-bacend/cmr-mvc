package kg.easyit.crm.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseTypeDto {

    Long id;

    String courseType;

    Integer durationInMonth;

    BigDecimal costIncreaseAmountPerMonth;
}
