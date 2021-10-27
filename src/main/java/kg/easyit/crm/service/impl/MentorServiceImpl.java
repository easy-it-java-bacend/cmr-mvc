package kg.easyit.crm.service.impl;

import kg.easyit.crm.exceptions.EmailAlreadyUsedException;
import kg.easyit.crm.exceptions.MentorNotFoundException;
import kg.easyit.crm.exceptions.PhoneNumberAlreadyUserException;
import kg.easyit.crm.mapper.MentorMapper;
import kg.easyit.crm.mapper.SubjectMapper;
import kg.easyit.crm.model.dto.MentorDto;
import kg.easyit.crm.model.dto.SubjectDto;
import kg.easyit.crm.model.entity.Mentor;
import kg.easyit.crm.model.request.ChangePasswordRequest;
import kg.easyit.crm.model.request.ChangeUsernameRequest;
import kg.easyit.crm.model.request.CreateMentorRequest;
import kg.easyit.crm.model.respoonse.MessageResponse;
import kg.easyit.crm.model.respoonse.SalaryResponse;
import kg.easyit.crm.repository.MentorRepository;
import kg.easyit.crm.service.MentorService;
import kg.easyit.crm.service.SubjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MentorServiceImpl implements MentorService {

    final MentorRepository mentorRepository;
    final SubjectService subjectService;

    @Override
    public MessageResponse save(CreateMentorRequest createMentorRequest) {
        try {
            log.info("Creating mentor object");
            List<SubjectDto> subjects = subjectService.getSubjectByIds(createMentorRequest.getSubjectsIds());

            if (mentorRepository.existsByEmail(createMentorRequest.getEmail())) {
                throw new EmailAlreadyUsedException("For email: " + createMentorRequest.getEmail());
            }

            if (mentorRepository.existsByPhoneNumber(createMentorRequest.getPhoneNumber())) {
                throw new PhoneNumberAlreadyUserException("For phone number: " + createMentorRequest.getPhoneNumber());
            }

            Mentor mentor = Mentor
                    .builder()
                    .firstName(createMentorRequest.getFirstName())
                    .lastName(createMentorRequest.getLastName())
                    .email(createMentorRequest.getEmail())
                    .phoneNumber(createMentorRequest.getPhoneNumber())
                    .salary(createMentorRequest.getSalary())
                    .subjects(SubjectMapper.INSTANCE.toEntityList(subjects))
                    .build();

            log.info("Mentor created successfully");
            mentorRepository.save(mentor);
            return MessageResponse.getSuccessMessage("Mentor created");
        } catch (EmailAlreadyUsedException | PhoneNumberAlreadyUserException ex) {
            log.error("Mentor creation failed");
            ex.printStackTrace();
            return MessageResponse.getErrorMessage(ex.getMessage());
        }
    }

    @Override
    public MentorDto findOne(Long id) {
        log.info("Trying to find mentor by id=" + id);
        return MentorMapper
                .INSTANCE
                .toDto(mentorRepository.findByIdAndIsDeletedFalse(id)
                        .orElseThrow(() -> {
                            log.error("Mentor not found by id=" + id);
                            throw new MentorNotFoundException("Mentor not found by id=" + id);
                        }));
    }

    @Override
    public MessageResponse deleteOne(Long id) {
        log.info("Trying to delete mentor by id=" + id);
        return mentorRepository.findByIdAndIsDeletedFalse(id).map(mentor -> {
            mentor.setIsDeleted(true);
            mentorRepository.save(mentor);
            log.info("Mentor deleted");
            return MessageResponse.getSuccessMessage("Mentor deleted");
        }).orElseThrow(() -> {
            log.error("Mentor not found or already deleted for id=" + id);
            throw new MentorNotFoundException("Mentor not found or already deleted for id=" + id);
        });
    }

    @Override
    public SalaryResponse getMonthlySalary(Long id) {
        log.info("Trying to get mentor salary info");
        return mentorRepository
                .getMonthlySalary(id)
                .map(salary -> {
                    return SalaryResponse.builder().salary(salary).build();
                }).orElseThrow(() -> {
                    log.error("Mentor not found for id=" + id);
                    throw new MentorNotFoundException("Mentor not found for id=" + id);
                });
    }
}
