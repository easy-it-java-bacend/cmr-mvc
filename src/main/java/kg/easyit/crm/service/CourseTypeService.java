package kg.easyit.crm.service;

import kg.easyit.crm.model.dto.CourseTypeDto;
import org.springframework.stereotype.Service;

@Service
public interface CourseTypeService {

    CourseTypeDto create(CourseTypeDto courseTypeDto);
    CourseTypeDto getById(Long id);

}
