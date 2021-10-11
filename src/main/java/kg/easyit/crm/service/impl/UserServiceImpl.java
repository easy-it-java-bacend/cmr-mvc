package kg.easyit.crm.service.impl;

import kg.easyit.crm.dto.UserDTO;
import kg.easyit.crm.entity.User;
import kg.easyit.crm.repository.UserRepository;
import kg.easyit.crm.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    @Override
    public UserDTO getOne(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserDTO
                .builder()
                .username(user.getUsername())
                .build();
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public void save(UserDTO userDTO) {

    }

}
