package app.note;

import app.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for managing Note entities.
 * Provides CRUD operations out of the box.
 *
 * @author El-Merjani Mohamed
 */

public interface NoteRepository extends JpaRepository<Note, Long> {

    public List<Note> findByStudent(Student student);

    //Méthode pour calculer la moyenne des notes d'un étudiant
    @Query("SELECT AVG(n.noteValue) FROM Note n WHERE n.student = :student")
    public BigDecimal calculateMeanForStudent(@Param("student") Student student);
}
