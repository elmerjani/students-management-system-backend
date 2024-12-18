package app.student;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents a student entity for database persistence.
 *
 * @author El-Merjani Mohamed
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Transient
    private BigDecimal notesMean;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(Long id, String fullName, LocalDate creationDate, BigDecimal notesMean) {
        this.id = id;
        this.fullName = fullName;
        this.creationDate = creationDate;
        this.notesMean = notesMean;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getNotesMean() {
        return notesMean;
    }

    public void setNotesMean(BigDecimal notesMean) {
        this.notesMean = notesMean;
    }


    // toString method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
