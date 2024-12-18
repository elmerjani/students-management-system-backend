package app.note;

import app.student.Student;
import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Represents a Note entity for database persistence.
 *
 * @author El-Merjani Mohamed
 */
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "note_value", nullable = false)
    private BigDecimal noteValue;

    // Constructors
    public Note() {}

    public Note(Long id, Student student, String courseName, BigDecimal noteValue) {
        this.id = id;
        this.student = student;
        this.courseName = courseName;
        this.noteValue = noteValue;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getNoteValue() {
        return noteValue;
    }

    public void setNoteValue(BigDecimal noteValue) {
        this.noteValue = noteValue;
    }

    // toString Method
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", student=" + student +
                ", courseName='" + courseName + '\'' +
                ", noteValue=" + noteValue +
                '}';
    }
}
