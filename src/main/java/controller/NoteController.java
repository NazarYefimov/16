package controller;

import model.Note;
import service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> listAllNotes() {
        return noteService.listAll();
    }

    @PostMapping
    public Note addNote(@RequestBody Note note) {
        return noteService.add(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable long id) {
        noteService.deleteById(id);
    }

    @PutMapping
    public void updateNote(@RequestBody Note note) {
        noteService.update(note);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable long id) {
        return noteService.getById(id);
    }
}