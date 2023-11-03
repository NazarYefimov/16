package com.example.todolist;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    NoteControllerTest() {
    }

    @BeforeEach
    void setUp() {
        // Можливо, тут потрібно додаткові підготовки перед тестами
    }

    @Test
    void listAllNotes() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/notes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        String content = result.getResponse().getContentAsString();
        assertNotNull(content);
        // Тут можна розібрати вміст відповіді, якщо потрібно
    }

    @Test
    void addNote() throws Exception {
        Note newNote = new Note(null, "New Note", "New Content");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newNote)))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        String content = result.getResponse().getContentAsString();
        assertNotNull(content);
        Note addedNote = objectMapper.readValue(content, Note.class);
        assertNotNull(addedNote.getId());
    }

    // Додайте аналогічні тести для інших методів контролера (delete, update, getById)
}
