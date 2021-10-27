package kg.easyit.crm.controller;

import kg.easyit.crm.exceptions.UsernameAlreadyExists;
import kg.easyit.crm.model.dto.UserDto;
import kg.easyit.crm.model.request.ChangePasswordRequest;
import kg.easyit.crm.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

    @GetMapping("/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDto userDTO) {
        try {
            return ResponseEntity.ok(userService.save(userDTO));
        } catch (UsernameAlreadyExists ex) {
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        return userService.updatePassword(changePasswordRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return userService.deleteOne(id);
    }

}
