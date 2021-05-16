package com.gn.springbasics.mrs.exp10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
//@ComponentScan("com.gn.springbasics.mrs.exp09")
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.gn.springbasics.mrs.exp09"))
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {

        ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
        System.out.println("contentbased filter bean found = " + appContext.containsBean("contentBasedFilter"));
        System.out.println("collaborative filter bean found = " + appContext.containsBean("collaborativeFilter"));
        System.out.println("movie bean found = " + appContext.containsBean("movie"));

    }

}
