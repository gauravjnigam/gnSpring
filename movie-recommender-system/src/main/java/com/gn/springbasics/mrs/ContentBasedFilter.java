package com.gn.springbasics.mrs;

public class ContentBasedFilter implements Filter{

    public String[] getRecommendations(String movie) {

        //implement logic of content based filter

        //return movie recommendations
        return new String[] {"Movie1", "Movie2", "Movie3"};
    }

}
