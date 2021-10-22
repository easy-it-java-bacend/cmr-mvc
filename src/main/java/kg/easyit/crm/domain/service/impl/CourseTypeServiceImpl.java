package kg.easyit.crm.domain.service.impl;

import kg.easyit.crm.domain.dto.CourseTypeDto;
import kg.easyit.crm.domain.service.CourseTypeService;
import kg.easyit.crm.mapper.CourseTypeMapper;
import kg.easyit.crm.repository.CourseTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseTypeServiceImpl implements CourseTypeService {

    final CourseTypeRepository courseTypeRepository;

    @Override
    public CourseTypeDto create(CourseTypeDto courseTypeDto) {
        courseTypeRepository.save(CourseTypeMapper.INSTANCE.toEntity(courseTypeDto));
        return courseTypeDto;
    }

    @Override
    public CourseTypeDto getById(Long id) {
        return CourseTypeMapper.INSTANCE.toDto(courseTypeRepository.findById(id).get());
    }
}
