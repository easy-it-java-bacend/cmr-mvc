package kg.easyit.crm.controller;

import kg.easyit.crm.domain.dto.UserDto;
import kg.easyit.crm.domain.request.ChangePasswordRequest;
import kg.easyit.crm.domain.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return userService.save(userDTO);
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
