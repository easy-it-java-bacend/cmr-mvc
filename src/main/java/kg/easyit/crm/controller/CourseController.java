package kg.easyit.crm.controller;

import kg.easyit.crm.model.request.CreateCourseRequest;
import kg.easyit.crm.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    final CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CreateCourseRequest createCourseRequest) {
        return ResponseEntity.ok(courseService.create(createCourseRequest));
    }
}
