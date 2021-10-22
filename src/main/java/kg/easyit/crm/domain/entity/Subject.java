package kg.easyit.crm.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_subject")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subject extends BaseEntity {

    @Column(name = "subject_name", nullable = false, unique = true)
    String subjectName;

}
