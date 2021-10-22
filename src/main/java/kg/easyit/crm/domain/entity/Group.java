package kg.easyit.crm.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_group")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group extends BaseEntity {

    @Column(name = "group_name", nullable = false, unique = true)
    String groupName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mentor_id", referencedColumnName = "id")
    Mentor mentor;

    @Column(name = "class_time", nullable = false)
    LocalDateTime classTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "group_has_student",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    List<Student> studentsOfGroup;
}
