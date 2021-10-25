package kg.easyit.crm.service;

import kg.easyit.crm.model.dto.CourseDto;
import kg.easyit.crm.model.request.CreateCourseRequest;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {

    CourseDto create(CreateCourseRequest createCourseRequest);

}
