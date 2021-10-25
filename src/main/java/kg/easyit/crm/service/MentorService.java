package kg.easyit.crm.service;

import kg.easyit.crm.model.dto.MentorDto;
import kg.easyit.crm.model.dto.UserDto;
import kg.easyit.crm.model.request.ChangePasswordRequest;
import kg.easyit.crm.model.request.ChangeUsernameRequest;
import kg.easyit.crm.model.request.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MentorService {
    MessageResponse save(UserDto userDTO);
    MentorDto findOne(Long id);
    MessageResponse updatePassword(ChangePasswordRequest changePasswordRequest);
    MessageResponse updateUsername(ChangeUsernameRequest changeUsernameRequest);
    MessageResponse deleteOne(Long id);
}
