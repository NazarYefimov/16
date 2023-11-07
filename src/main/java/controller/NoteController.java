package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {

    @GetMapping("/list")
    public String listNotes(Model model) {
        // Логіка для отримання списку нотаток та передачі їх на сторінку
        return "note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {
        // Логіка для видалення нотатки по ID
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam Long id, Model model) {
        // Логіка для отримання нотатки за ID та передачі її на сторінку редагування
        return "note/edit";
    }

    @PostMapping("/edit")
    public String saveEditedNote(@RequestParam Long id, @RequestParam String title, @RequestParam String content) {
        // Логіка для збереження оновленого контенту нотатки
        return "redirect:/note/list";
    }
}