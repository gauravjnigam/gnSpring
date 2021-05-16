package com.gn.springbasics.mrs;

import com.gn.springbasics.mrs.exp10.ContentBasedFilter;
import com.gn.springbasics.mrs.exp10.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieRecommenderSystemApplication {
	private static Logger logger = LoggerFactory.getLogger(MovieRecommenderSystemApplication.class);
	public static void main(String[] args) {


		//SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		//create object of RecommenderImplementation class
//		RecommenderImplementation recommender = new RecommenderImplementation();
/* 		-> code without spring
		//passing name of the filter as constructor argument
		//code is now loosely coupled as we are passing the name of the filter to be used as a constructor argument.
		RecommenderImplementation recommender = new RecommenderImplementation(new ContentBasedFilter());
		//call method to get recommendations
		String[] result = recommender.recommendMovies("Finding Dory");

 */
		//ApplicationContext manages the beans and dependencies
		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

// --------------------------------------------------------
//		//RecommenderImplementation injects dependency using constructor
//		System.out.println("\n*************************************************");
//		System.out.println("Calling getBean() on RecommenderImplementation");
//		RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
//		String[] result = recommender.recommendMovies("Finding Dory");
//		System.out.println(Arrays.toString(result));
//
//		//RecommenderImplementation injects dependency using setter method
//		System.out.println("\n*************************************************");
//		System.out.println("Calling getBean() on RecommenderImplementation2");
//		RecommenderImplementation2 recommender2 = appContext.getBean(RecommenderImplementation2.class);
//		result = recommender2.recommendMovies("Finding Dory");
//		System.out.println(Arrays.toString(result));

// --------------------------------------------------------
//		//Retrieve singleton bean from application context thrice
//		ContentBasedFilter cbf1 = appContext.getBean(ContentBasedFilter.class);
//		ContentBasedFilter cbf2 = appContext.getBean(ContentBasedFilter.class);
//		ContentBasedFilter cbf3= appContext.getBean(ContentBasedFilter.class);
//
//		System.out.println(cbf1);
//		System.out.println(cbf2);
//		System.out.println(cbf3);
//
//		//Retrieve prototype bean from application context thrice
//		CollaborativeFilter cf1 = appContext.getBean(CollaborativeFilter.class);
//		CollaborativeFilter cf2 = appContext.getBean(CollaborativeFilter.class);
//		CollaborativeFilter cf3 = appContext.getBean(CollaborativeFilter.class);
//
//		System.out.println(cf1);
//		System.out.println(cf2);
//		System.out.println(cf3);

// --------------------------------------------------------

		ContentBasedFilter filter = appContext.getBean(ContentBasedFilter.class);
		logger.info("\nCon.toString()tentBasedFilter bean with singleton scope");
		logger.info(filter.toString());

//Retrieve prototype bean from the singleton bean thrice
		Movie movie1 = filter.getMovie();
		Movie movie2 = filter.getMovie();
		Movie movie3 = filter.getMovie();

		logger.info("Movie bean with prototype scope");
		logger.info(movie1.toString());
		logger.info(movie2.toString());
		logger.info(movie3.toString());

	}

}
