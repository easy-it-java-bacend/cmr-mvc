package kg.easyit.crm.service.impl;

import kg.easyit.crm.model.dto.MentorDto;
import kg.easyit.crm.model.dto.UserDto;
import kg.easyit.crm.model.request.ChangePasswordRequest;
import kg.easyit.crm.model.request.ChangeUsernameRequest;
import kg.easyit.crm.model.request.MessageResponse;
import kg.easyit.crm.repository.MentorRepository;
import kg.easyit.crm.service.MentorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MentorServiceImpl implements MentorService {

    final MentorRepository mentorRepository;

    @Override
    public MessageResponse save(UserDto userDTO) {
        return null;
    }

    @Override
    public MentorDto findOne(Long id) {
        return null;
    }

    @Override
    public MessageResponse updatePassword(ChangePasswordRequest changePasswordRequest) {
        return null;
    }

    @Override
    public MessageResponse updateUsername(ChangeUsernameRequest changeUsernameRequest) {
        return null;
    }

    @Override
    public MessageResponse deleteOne(Long id) {
        return null;
    }
}
