package kg.easyit.crm.domain.service;

import kg.easyit.crm.domain.dto.UserDTO;
import kg.easyit.crm.domain.request.ChangePasswordRequest;
import kg.easyit.crm.domain.request.ChangeUsernameRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseEntity<?> save(UserDTO userDTO);
    ResponseEntity<?> findOne(Long id);
    ResponseEntity<?> updatePassword(ChangePasswordRequest changePasswordRequest);
    ResponseEntity<?> updateUsername(ChangeUsernameRequest changeUsernameRequest);
    ResponseEntity<?> deleteOne(Long id);

}
