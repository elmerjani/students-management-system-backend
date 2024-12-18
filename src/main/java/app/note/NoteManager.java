package app.note;

import app.student.Student;
import org.springframework.stereotype.Component;

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
}
