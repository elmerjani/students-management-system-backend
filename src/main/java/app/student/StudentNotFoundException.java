package app.student;

/**
 * @author El-Merjani Mohamed
 **/
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Student not found");
    }
}
