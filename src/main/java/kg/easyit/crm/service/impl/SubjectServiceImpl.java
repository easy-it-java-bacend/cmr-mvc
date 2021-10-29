package kg.easyit.crm.service.impl;

import kg.easyit.crm.mapper.SubjectMapper;
import kg.easyit.crm.model.dto.SubjectDto;
import kg.easyit.crm.repository.SubjectRepository;
import kg.easyit.crm.service.SubjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectServiceImpl implements SubjectService {

    final SubjectRepository subjectRepository;

    @Override
    public List<SubjectDto> getSubjectByIds(List<Long> ids) {
        return SubjectMapper
                .INSTANCE
                .toDtoList(subjectRepository.getAllByIsDeletedFalse()
                        .map(subjects -> subjects.stream().filter(subject -> ids.contains(subject.getId())).collect(Collectors.toList()))
                        .orElseThrow(() -> new RuntimeException("No subjects are available. Please create subject first")));
    }
}
