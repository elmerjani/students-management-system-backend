package app.student;

import app.note.NoteManager;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 @author El-Merjani Mohamed
 **/
@Component
public class StudentManager {


    private final NoteManager noteManager;
    private final StudentRepository studentRepository;

    public StudentManager(StudentRepository studentRepository, NoteManager noteManager) {
        this.studentRepository = studentRepository;
        this.noteManager = noteManager;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream()
                .peek(student -> {
                    BigDecimal notesMean = noteManager.calculateMeanForStudent(student);
                    student.setNotesMean(notesMean);
                })
                .collect(Collectors.toList());
    }

    public Student getStudentDetails(Long id)  throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException();
        }
        Student studentValue = student.get();
        studentValue.setNotesMean(noteManager.calculateMeanForStudent(studentValue));
        return studentValue;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

}
