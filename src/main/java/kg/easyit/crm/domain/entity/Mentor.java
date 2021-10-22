package kg.easyit.crm.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_mentor")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mentor extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @Column(name = "salary", nullable = false)
    BigDecimal salary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "mentor_has_subject",
            joinColumns = @JoinColumn(name = "mentor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    List<Subject> subjects;
}
