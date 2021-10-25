package kg.easyit.crm.model.entity;

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

    @Column(name = "is_deleted", nullable = false)
    Boolean isDeleted;

    @Column(name = "date_created")
    Date dateCreated;

    @Column(name = "date_updated")
    Date dateUpdated;

    @PrePersist
    protected void onCreate() {
        isDeleted = false;
        dateCreated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dateUpdated = new Date();
    }


}
