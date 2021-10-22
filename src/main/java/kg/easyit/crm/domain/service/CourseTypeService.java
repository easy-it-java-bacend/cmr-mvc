package kg.easyit.crm.domain.service;

import kg.easyit.crm.domain.dto.CourseTypeDto;
import org.springframework.stereotype.Service;

@Service
public interface CourseTypeService {

    CourseTypeDto create(CourseTypeDto courseTypeDto);
    CourseTypeDto getById(Long id);

}
