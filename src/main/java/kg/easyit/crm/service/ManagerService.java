package kg.easyit.crm.service;

import kg.easyit.crm.model.dto.ManagerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService {

    ResponseEntity<?> save(ManagerDto managerDTO);
    ResponseEntity<?> findOne(Long id);
    ResponseEntity<?> updateFirstName(String firstName);
    ResponseEntity<?> updateLastName(String lastName);
    ResponseEntity<?> updatePhoneNumber(String phoneNumber);
    ResponseEntity<?> deleteOne(Long id);
}
