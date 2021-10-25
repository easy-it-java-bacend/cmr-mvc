package kg.easyit.crm.service.impl;

import kg.easyit.crm.exceptions.UsernameAlreadyExists;
import kg.easyit.crm.model.dto.UserDto;
import kg.easyit.crm.model.request.ChangePasswordRequest;
import kg.easyit.crm.model.request.ChangeUsernameRequest;
import kg.easyit.crm.model.request.MessageResponse;
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

    final UserRepository userRepository;

    @Override
    public MessageResponse save(UserDto userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new UsernameAlreadyExists("For username: " + userDTO.getUsername());
        }
        userRepository.save(UserMapper.INSTANCE.toEntity(userDTO));
        return new MessageResponse("User created.");
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