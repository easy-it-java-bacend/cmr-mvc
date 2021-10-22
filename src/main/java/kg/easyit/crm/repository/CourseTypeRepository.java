package kg.easyit.crm.repository;

import kg.easyit.crm.domain.entity.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, Long> {
}
