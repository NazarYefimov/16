package com.example.todolist;

import model.Note;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    @Test
    void setIdAndGetId() {
        Note note = new Note(null, "Test Title", "Test Content");
        note.setId(1L);
        assertEquals(1L, note.getId());
    }

    @Test
    void getTitle() {
        Note note = new Note(null, "Test Title", "Test Content");
        assertEquals("Test Title", note.getTitle());
    }

    @Test
    void getContent() {
        Note note = new Note(null, "Test Title", "Test Content");
        assertEquals("Test Content", note.getContent());
    }
}
