package kg.easyit.crm.service;

import kg.easyit.crm.model.dto.ManagerDto;
import kg.easyit.crm.model.respoonse.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService extends UserDetailsService {

    MessageResponse save(ManagerDto managerDTO);
    ManagerDto findOne(Long id);
    MessageResponse updateFirstName(String firstName);
    MessageResponse updateLastName(String lastName);
    MessageResponse updatePhoneNumber(String phoneNumber);
    MessageResponse deleteOne(Long id);
}
