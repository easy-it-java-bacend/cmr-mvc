package kg.easyit.crm.repository;

import kg.easyit.crm.model.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query(value = "SELECT m.email FROM tb_manager as m WHERE is_deleted = false", nativeQuery = true)
    Optional<List<String>> getAllEmails();

    Optional<Manager> findByIdAndIsDeletedFalse(Long id);
    Optional<List<Manager>> findAllByIsDeletedFalse();
}
