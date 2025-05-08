package com.notes.search.controller;

import com.notes.search.entities.Notes;
import com.notes.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private SearchService notesService;

    @PutMapping("/")
    public Notes addNotes(@RequestBody Notes notes) {
        return notesService.addNotes(notes);
    }

    @GetMapping("/all")
    public Iterable<Notes> getAll() {
        return notesService.getAll();
    }

    @GetMapping("/search")
    public List<Notes> searchNotes(@RequestParam String query) {
        return notesService.search(query);
    }
}
