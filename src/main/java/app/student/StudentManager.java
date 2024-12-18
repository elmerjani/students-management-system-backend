package app.student;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 @author El-Merjani Mohamed
 **/
@Component
public class StudentManager {

    StudentRepository studentRepository;

    public StudentManager(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentDetails(Long id)  throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException();
        }
        return student.get();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }




}
