package com.notes.search.service;

import com.notes.search.entities.Notes;
import com.notes.search.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private NotesRepository notesRepository;

    public Notes addNotes(Notes notes) {
        return notesRepository.save(notes);
    }

    public Iterable<Notes> getAll() {
        return notesRepository.findAll();
    }

    public List<Notes> search(String text) {
        return notesRepository.searchByKeyword(text);
    }

}
