package app.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

/**
 * @author El-Merjani Mohamed
 **/
@RestController
public class StudentController {

    private final StudentManager studentManager;


    public StudentController(StudentManager studentManager) {
        this.studentManager = studentManager;

    }

    @GetMapping(value = "/students")
    public List<Student> getAllStudents() {
        return studentManager.getAllStudents();
    }

    @GetMapping(value = "/students/{id}")
    public Student getStudentDetails(@PathVariable Long id) {
        return studentManager.getStudentDetails(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/students")
    public ResponseEntity<Void> createStudent(@RequestBody Student newStudent) {
        Student student = new Student(null, newStudent.getFullName(), LocalDate.now(),null);
        Student savedStudent = studentManager.addStudent(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void studentNotFoundExceptionHandler(StudentNotFoundException ex) {}
}
