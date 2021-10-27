package kg.easyit.crm.service.impl;

import kg.easyit.crm.exceptions.UsernameAlreadyExists;
import kg.easyit.crm.model.dto.UserDto;
import kg.easyit.crm.model.request.ChangePasswordRequest;
import kg.easyit.crm.model.request.ChangeUsernameRequest;
import kg.easyit.crm.model.respoonse.MessageResponse;
import kg.easyit.crm.service.UserService;
import kg.easyit.crm.mapper.UserMapper;
import kg.easyit.crm.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    @Override
    public MessageResponse save(UserDto userDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> findOne(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> updatePassword(ChangePasswordRequest changePasswordRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateUsername(ChangeUsernameRequest changeUsernameRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteOne(Long id) {
        return null;
    }
}
