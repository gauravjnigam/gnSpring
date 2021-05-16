package com.gn.springbasics.mrs.exp13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class MovieRecommenderSystemApplication {
    private static final Logger logger = LoggerFactory.getLogger(MovieRecommenderSystemApplication.class);

    public static void main(String[] args) {

        //ApplicationContext manages the beans and dependencies
        AnnotationConfigApplicationContext appContext = //SpringApplication.run(MovieRecommenderSystemApplication.class, args);
                new AnnotationConfigApplicationContext(MovieRecommenderSystemApplication.class);
        System.out.println();

        //Retrieving singleton bean from application context
        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
        System.out.println(recommender);

        logger.info("{}", recommender);
        logger.info("{}", recommender.getFilter());

        //call method to get recommendations
        String[] result = recommender.recommendMovies("Finding Dory");

        //display results
        System.out.println(Arrays.toString(result));
        appContext.close();

    }

}
