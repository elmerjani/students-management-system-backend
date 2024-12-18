package app.note;

import app.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing Note entities.
 * Provides CRUD operations out of the box.
 *
 * @author El-Merjani Mohamed
 */

public interface NoteRepository extends JpaRepository<Note, Long> {
    public List<Note> findByStudent(Student student);
}
