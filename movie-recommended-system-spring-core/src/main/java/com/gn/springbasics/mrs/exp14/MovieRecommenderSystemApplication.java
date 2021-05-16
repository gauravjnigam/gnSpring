package com.gn.springbasics.mrs.exp14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MovieRecommenderSystemApplication {
    private static final Logger logger = LoggerFactory.getLogger(MovieRecommenderSystemApplication.class);

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");

        //check the beans which have been loaded
        System.out.println("\nBeans loaded:");
        System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

        //retrieve bean from the application context
        RecommenderImplementation recommender = appContext.getBean("recommenderImplementation", RecommenderImplementation.class);


        //call method to get recommendations
        String[] result = recommender.recommendMovies("Finding Dory");

        //display results
        System.out.println(Arrays.toString(result));

        appContext.close();


    }

}
