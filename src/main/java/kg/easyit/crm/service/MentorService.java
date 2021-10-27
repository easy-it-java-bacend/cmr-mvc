package kg.easyit.crm.service;

import kg.easyit.crm.model.dto.MentorDto;
import kg.easyit.crm.model.request.ChangePasswordRequest;
import kg.easyit.crm.model.request.ChangeUsernameRequest;
import kg.easyit.crm.model.request.CreateMentorRequest;
import kg.easyit.crm.model.respoonse.MessageResponse;
import kg.easyit.crm.model.respoonse.SalaryResponse;
import org.springframework.stereotype.Service;

@Service
public interface MentorService {
    MessageResponse save(CreateMentorRequest createMentorRequest);
    MentorDto findOne(Long id);
    MessageResponse deleteOne(Long id);
    SalaryResponse getMonthlySalary(Long id);
}
