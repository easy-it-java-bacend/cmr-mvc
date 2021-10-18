package kg.easyit.crm.domain.service;

import kg.easyit.crm.domain.dto.ManagerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService {

    ResponseEntity<?> save(ManagerDTO managerDTO);
    ResponseEntity<?> findOne(Long id);
    ResponseEntity<?> updateFirstName(String firstName);
    ResponseEntity<?> updateLastName(String lastName);
    ResponseEntity<?> updatePhoneNumber(String phoneNumber);
    ResponseEntity<?> deleteOne(Long id);
}
