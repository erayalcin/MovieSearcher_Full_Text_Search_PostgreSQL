package com.gradproject.moviesearcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;



    public List<Media> searchMedia(String query) {
        String formattedQueryString = query.replace(" ", " | ");
        List<Media> queryResults = mediaRepository.findByFullTextSearchOrderByRank(formattedQueryString);
       
        

        return queryResults;
    }
}