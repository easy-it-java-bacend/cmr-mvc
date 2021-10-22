package kg.easyit.crm.domain.service;

import kg.easyit.crm.domain.dto.CourseDto;
import kg.easyit.crm.domain.request.CreateCourseRequest;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {

    CourseDto create(CreateCourseRequest createCourseRequest);

}
