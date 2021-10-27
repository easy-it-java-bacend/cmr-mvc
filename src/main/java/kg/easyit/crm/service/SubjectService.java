package kg.easyit.crm.service;

import kg.easyit.crm.model.dto.SubjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    List<SubjectDto> getSubjectByIds(List<Long> ids);

}
