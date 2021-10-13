package kg.easyit.crm.controller;

import kg.easyit.crm.dto.UserDTO;
import kg.easyit.crm.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

    @RequestMapping(value = "/register")
    public String register() {
        return "register-form";
    }

    @RequestMapping(value = "/confirmation")
    public String confirmation(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String email,
                               @RequestParam String phoneNumber) {

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(phoneNumber);
        // service in DTO
        return "confirmation-form";
    }
}
