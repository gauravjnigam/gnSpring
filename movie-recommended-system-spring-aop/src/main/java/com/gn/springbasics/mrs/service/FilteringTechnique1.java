package com.gn.springbasics.mrs.service;

import com.gn.springbasics.mrs.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilteringTechnique1 {

    @Autowired
    private Movie movie;

    public String contentBasedFiltering() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String movieDetails = movie.getMovieDetails();
        return movieDetails;
    }
}