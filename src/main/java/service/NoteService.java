package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.Note;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final Map<Long, Note> noteMap = new HashMap<>();
    private final Random random = new Random();

    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }

    public Note add(Note note) {
        Long id = random.nextLong(); // Генеруємо випадковий ID
        note.setId(id);
        noteMap.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Нотатка з вказаним ідентифікатором не існує");
        }
        noteMap.remove(id);
    }

    public void update(Note note) {
        long id = note.getId();
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Нотатка з вказаним ідентифікатором не існує");
        }
        noteMap.put(id, note);
    }

    public Note getById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Нотатка з вказаним ідентифікатором не існує");
        }
        return noteMap.get(id);
    }
}
