package kg.easyit.crm.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_course_type")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseType extends BaseEntity {

    @Column(name = "course_type", nullable = false)
    String courseType;

    @Column(name = "duration_in_month", nullable = false)
    Integer durationInMonth;

    @Column(name = "cost_increase_amount_per_month", nullable = false)
    BigDecimal costIncreaseAmountPerMonth;
}
