package com.notes.search.repository;

import com.notes.search.entities.Notes;

import java.util.List;

public interface CustomNotesRepository {

    List<Notes> searchByKeyword(String keyword);
}
