package app.note;

import app.student.Student;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

/**
 * @author El-Merjani Mohamed
 **/
@Component
public class NoteManager {

    private final NoteRepository noteRepository;

    public NoteManager(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getStudentNotes(Student student) {
        return noteRepository.findByStudent(student);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note getNoteDetails(Long id) throws NoteNotFoundException {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isEmpty()) {
            throw new NoteNotFoundException();
        }
        return note.get();
    }

    /**
     * Calculates the mean of notes for a specific student.
     *
     * @param student the student whose notes mean is to be calculated
     * @return the mean of the student's notes
     */
    public BigDecimal calculateMeanForStudent(Student student) {
        BigDecimal meanNote =  noteRepository.calculateMeanForStudent(student);
        return (meanNote == null ? null : meanNote.setScale(2, RoundingMode.HALF_UP));
    }
}
