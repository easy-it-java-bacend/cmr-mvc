package kg.easyit.crm.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "date_created")
    Date dateCreated;

}
