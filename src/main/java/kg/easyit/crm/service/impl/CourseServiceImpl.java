package kg.easyit.crm.service.impl;

import kg.easyit.crm.model.dto.CourseDto;
import kg.easyit.crm.model.request.CreateCourseRequest;
import kg.easyit.crm.service.CourseService;
import kg.easyit.crm.service.CourseTypeService;
import kg.easyit.crm.mapper.CourseMapper;
import kg.easyit.crm.repository.CourseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseServiceImpl implements CourseService {

    final CourseRepository courseRepository;
    final CourseTypeService courseTypeService;

    @Override
    public CourseDto create(CreateCourseRequest createCourseRequest) {

        CourseDto courseDto = CourseDto
                .builder()
                .monthlyCost(createCourseRequest.getMonthlyCost())
                .courseName(createCourseRequest.getCourseName())
                .classesPerMonth(createCourseRequest.getClassesPerMonth())
                .courseTypeDto(courseTypeService.getById(createCourseRequest.getCourseTypeId()))
                .build();

        courseRepository.save(CourseMapper.INSTANCE.toEntity(courseDto));
        return courseDto;
    }
}
