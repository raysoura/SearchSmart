package com.notes.search.repository;

import com.notes.search.entities.Notes;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface NotesRepository extends ElasticsearchRepository<Notes, Integer>, CustomNotesRepository {

    List<Notes> findByTitleContainingOrContentContaining(String title, String content);
}
