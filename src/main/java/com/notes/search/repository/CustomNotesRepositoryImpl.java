package com.notes.search.repository;

import com.notes.search.entities.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomNotesRepositoryImpl implements CustomNotesRepository{
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public List<Notes> searchByKeyword(String keyword) {
        Criteria titleCriteria = Criteria.where("title").matches(keyword);
        Criteria bodyCriteria = Criteria.where("content").matches(keyword);
        Criteria criteria = new Criteria().or(titleCriteria).or(bodyCriteria);

        CriteriaQuery query = new CriteriaQuery(criteria);

        SearchHits<Notes> searchHits = elasticsearchOperations.search(query, Notes.class);

        return searchHits.get().map(SearchHit::getContent).collect(Collectors.toList());
    }
}
