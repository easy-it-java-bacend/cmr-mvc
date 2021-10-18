package kg.easyit.crm.domain.service.impl;

import kg.easyit.crm.domain.dto.UserDTO;
import kg.easyit.crm.domain.request.ChangePasswordRequest;
import kg.easyit.crm.domain.request.ChangeUsernameRequest;
import kg.easyit.crm.domain.request.MessageResponse;
import kg.easyit.crm.domain.service.UserService;
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

    final UserRepository userRepository;

    @Override
    public ResponseEntity<?> save(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("User with username='" + userDTO.getUsername() + "' is already defined");
        }
        userRepository
                .save(UserMapper.INSTANCE.toEntity(userDTO));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User with username='" + userDTO.getUsername() + "' is created.");
    }

    @Override
    public ResponseEntity<?> findOne(Long id) {
        try {
            return userRepository.findByIdAndIsDeletedFalse(id).map(ResponseEntity::ok)
                    .orElseThrow(() -> new RuntimeException("User with id=" + id + " not found"));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updatePassword(ChangePasswordRequest changePasswordRequest) {
        return userRepository.findByIdAndIsDeletedFalse(changePasswordRequest.getId()).map(user -> {
            user.setPassword(changePasswordRequest.getNewPassword());
            userRepository.save(user);
            return ResponseEntity.ok("Password changed successfully");
        }).orElse(ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("User with id=" + changePasswordRequest.getId() + " not found."));
    }

    @Override
    public ResponseEntity<?> updateUsername(ChangeUsernameRequest changeUsernameRequest) {
        if (userRepository.existsByUsername(changeUsernameRequest.getUsername())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("Username '" + changeUsernameRequest.getUsername() + "' is already taken"));
        }
        return userRepository.findByIdAndIsDeletedFalse(changeUsernameRequest.getId()).map(user -> {
            user.setUsername(changeUsernameRequest.getUsername());
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Username has changed successfully"));
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageResponse("User with id=" + changeUsernameRequest.getId() + " not found or deleted")));
    }

    @Override
    public ResponseEntity<?> deleteOne(Long id) {
        return userRepository.findByIdAndIsDeletedFalse(id).map(user -> {
            user.setIsDeleted(true);
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("User with id=" + id + " is deleted"));
        }).orElse(ResponseEntity
                .status(HttpStatus.
                        NOT_FOUND)
                .body(new MessageResponse("User with id=" + id + " not found or deleted.")));
    }
}
