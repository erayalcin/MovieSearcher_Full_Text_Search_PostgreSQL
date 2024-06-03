package com.gradproject.moviesearcher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    
    @Query(value = "SELECT * FROM netflix_contents " +
               "WHERE document_with_idx @@ to_tsquery('english', :tsQuery) " +
               "ORDER BY ts_rank(document_with_idx, to_tsquery('english', :tsQuery)) DESC", 
       nativeQuery = true)

    List<Media> findByFullTextSearchOrderByRank(@Param("tsQuery") String tsQuery);

}
