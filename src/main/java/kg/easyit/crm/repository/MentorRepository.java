package kg.easyit.crm.repository;

import kg.easyit.crm.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

    Optional<Mentor> findByIdAndIsDeletedFalse(Long id);

    @Query(value = "SELECT m.salary FROM tb_mentor as m WHERE m.is_deleted=false AND m.id=?1", nativeQuery = true)
    Optional<BigDecimal> getMonthlySalary(Long id);

}
