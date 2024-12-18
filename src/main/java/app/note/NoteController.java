package app.note;

import app.student.Student;
import app.student.StudentManager;
import app.student.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author El-Merjani Mohamed
 **/

@RestController
public class NoteController {

    private StudentManager studentManager;
    private NoteManager noteManager;

    public NoteController(NoteManager noteManager, StudentManager studentManager) {
        this.noteManager = noteManager;
        this.studentManager = studentManager;
    }

    @GetMapping(value = "/notes")
    public List<Note> getNotes() {
        return noteManager.getAllNotes();
    }
    @GetMapping(value = "/notes/{id}")
    public Note getNoteDetails(@PathVariable Long id) {
        return noteManager.getNoteDetails(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/students/{studentId}/notes")
    public ResponseEntity<Note> createNote(@PathVariable Long studentId, @RequestBody Note note) {
        Student student = studentManager.getStudentDetails(studentId);
        Note newNote = new Note(null, student, note.getCourseName(), note.getNoteValue());
        Note savedNote = noteManager.createNote(newNote);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{noteId}").buildAndExpand(savedNote.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @GetMapping("/students/{studentId}/notes")
    public List<Note> getNotesByStudentId(@PathVariable Long studentId) {
        Student student = studentManager.getStudentDetails(studentId);
        return noteManager.getStudentNotes(student);

    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void studentNotFoundExceptionHandler(StudentNotFoundException ex) {}

}
