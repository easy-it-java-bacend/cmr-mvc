package kg.easyit.crm.controller;

import kg.easyit.crm.dto.UserDTO;
import kg.easyit.crm.entity.User;
import kg.easyit.crm.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

    @RequestMapping(value = "/greeting/{id}")
    public String greeting(@PathVariable Long id, Model model) {
        UserDTO userDTO = userService.getOne(id);
        model.addAttribute("username", userDTO.getUsername());
        return "greeting";
    }
}
