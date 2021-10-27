package kg.easyit.crm.controller;

import kg.easyit.crm.exceptions.MentorNotFoundException;
import kg.easyit.crm.model.request.CreateMentorRequest;
import kg.easyit.crm.service.MentorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentor")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MentorController {

    final MentorService mentorService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CreateMentorRequest createMentorRequest) {
        try {
            return ResponseEntity.ok(mentorService.save(createMentorRequest));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(mentorService.findOne(id));
        } catch (MentorNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete-one/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(mentorService.deleteOne(id));
        } catch (MentorNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/get-monthly-salary/{id}")
    public ResponseEntity<?> getMonthlySalary(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(mentorService.getMonthlySalary(id));
        } catch (MentorNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
