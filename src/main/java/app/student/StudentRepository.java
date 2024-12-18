package app.student;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author El-Merjani Mohamed
 **/
public interface StudentRepository extends JpaRepository<Student, Long> {
}
