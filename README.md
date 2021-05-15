## Spring learing 

# What is Spring?
The Spring framework is an open-source Java application framework, which is based on two key principles: dependency injection and Inversion of Control. Spring has the ability to autowire the dependency at run time, which allows the developer to write loosely coupled code.

Spring framework uses metadata in the form of xml file or java annotations to create objects and identifies dependencies, thereby producing a ready-to-use application.

      Metadata      Business Object 
      
      ------------------------------
            SPRING CONTAINER
      ------------------------------
                  |
                  |
                  |
                  V
            ---------------
        Ready to use application 
            ---------------
            
A typical application has a lot of classes and dependencies
* Tight coupling
* Loose coupling

## Tight coupling 
Tightly coupled code involves creating an instance of the dependency inside the class
 
      public class ClassA {
          DependencyOption1 dependency1 = new DependencyOption1();
          //...
      }
      public class DependencyOption1 {
          //...
      }
      public class DependencyOption2 {
          //...
      }
      
 
 Problems can arise when we want to use a different option for the dependency. Suppose if we ClassA wants to rely on different dependency
 This entails changing the code of ClassA, which would be a disadvantage of using tightly coupled code.
 
 ## Loose coupling 
A better way would be to implement an interface. This will remove the direct instantiation of the DependencyOption, and instead, ask for the type of filter as an argument to the constructor.
 
      interface DepedencyOption {
          //method definitions
      }
      public class DependencyOption1 implements DepedencyOption {
          //implement interface methods
      }
      public class ClassA {

          DepedencyOption dependency;

          public ClassA(DepedencyOption dependency) {
              this.dependency = dependency;
          }

          //...
      }

This way ClassA is not dependent on a specific type of dependency and can be used with both a DependencyOption1 and DependencyOption2. The above code snippet is an example of loosely coupled code. Loose coupling has a number of advantages.

The Spring framework take cares of writing the above code on its own. Spring creates objects and populates dependencies. As a programmer, you only have to tell which objects it has to create and what the dependencies of each object are.

*Spring inverts the control by taking responsibility for populating the dependency. This is referred to as Inversion of Control (IoC). Spring is a dependency injection framework that promotes loosely coupled code.

# Spring History 

# Spring terminology 
### Beans
   Beans are the objects of classes that are managed by Spring.
   Spring manages all the dependencies of an object and instantiates the object after injecting the required dependencies. The @Component annotation is the most common method of defining beans.
   
      @Component
      public class ClassA {

      }


### Autowiring
its a process of identifying the dependency, looking for match and populating the dependency. 
Spring uses @Autowire annotation to find the dependency and inject into other bean. Spring throws error if it finds more then one dependency unless developer explicitly defines it. 

      @Component
      class ClassA(){
          @Autowired
          private Dependency dependency;
          //...
      }

      @Component
      class DependencyOption1 implements Dependency {

      }

### Dependency injection
Dependency injection is the process of looking up the beans that are needed for a specific bean to function and injects them as a dependency. Spring can perform dependency injection by using constructor or by using a setter method.

### Inversion of control

Traditionally, the class which needed the dependency created an instance of the dependency. The class decided when to create the dependency and how to create it. For example, DependencyOption1 class is a dependency of ClassA class, which creates its object:

      class ClassA{

          private DependencyOption1 dependency1 = new DependencyOption1();
          //...
      }

Spring takes this responsibility from the class and creates the object itself. The developer simply mentions the dependency and the framework takes care of the rest.

      class ClassA{

          private Dependency dependency;
          //...
      }

control moves from the component that needs the dependency to the framework. The framework takes the responsibility for finding out the dependencies of a component, ensuring their availability and injecting them in the component. This process is called Inversion of Control.

             Traditional Approach                                 Inversion of control 
      ----------------------------------------             ----------------------------------------
       ClassA ----creates------> Dependency               ClassA <----Injects------ Dependency 

### IoC container 

An IoC container is a framework that provides the Inversion of Control functionality. The IoC container manages the beans. For the above mentioned example, it creates an instance of the Dependency class, then creates an instance of ClassA class, and then injects the Dependency object as a dependency into the ClassA object.

Spring offers two implementations of the IoC container:

*Bean factory
*Application context

Both of them are interfaces that have different implementations available. Application context is the typical IoC container in the context of Spring. Spring recommends using it unless there is a memory concern, like in a mobile device. If available memory is low, bean factory should be used.

### Bean factory
The basic version of the Spring IoC container is bean factory. It is the legacy IoC container and provides basic management for beans and wiring of dependencies. In Spring, bean factory still exists to provide backward compatibility.

### Application context
Application context adds more features to the bean factory that are typically needed by an enterprise application. It is the most important part of the Spring framework. All the core logic of Spring happens here. It includes basic management of beans and wiring of dependencies as provided by the bean factory.

# Spring Architechture 

Spring framework is made of multiple modules which are grouped together in layers as shown below.
its built in modular way which enables developer to choose specific module instead of using a whole framework. 
## Spring modules 
![SpringFramework Architechture](https://github.com/gauravjnigam/gnSpring/blob/master/docs/SpringFrameworkArch.png)


### Spring core container 
this contains Beans, Core, Context, and Spring Expression Language (SpEL). These modules provide fundamental functionality of the Spring framework, like Inversion of Control (IoC), dependency injection, internationalization as well as support for querying the object at run time.

### Data access / integration 
Spring has very good integration with data and integration layers, and provides support to interact with databases. It contains modules like JDBC, ORM, OXM, JSM, and Transactions.
* The JDBC (Java Database Connectivity) module allows the data layer to interact with databases to get data or store data, or to interact with other systems without the need of cumbersome JDBC coding. Spring JDBC is very straightforward as compared to plain JDBC and makes the code very short.

* The ORM (Object Relational Mapping) module provides support to integrate with ORM frameworks including Hibernate and JPA.

* The JMS (Java Messaging Service) module talks to other applications through the queue to produce and consume messages.

* The OXM (object-XML mapping) module makes the object-to-XML transformation easy by providing useful features.

* The transaction management module provides support for successful rollback in case a transaction fails.

### Spring Web 
It contains the Web, Servlets, Portlets, and Sockets modules to support the creation of a web application. Spring offers a web framework of its own called Spring MVC.

### Test
The Test module handles the cross cutting concern of unit testing. The Spring Test framework supports testing with JUnit, TestNG, as well as creating mock objects for testing the code in isolation.

### AOP 
The AOP Module provides the Aspect oriented programming functionality to address cross cutting concerns like security, logging in application. 
Spring has its own module i.e Spring AOP which provides basic aspect oriented programming functionality. This can be integrated with AspectJ to achieve advanced AOP features.

# Spring Project 
Sr No. | Project | Description |
--- | --- | --- |
1 | Spring Boot | used to develop micro services, it provides nice features like startup project, auto configuration, actuator etc  |
2 | Spring Cloud | used to develop cloud native application that can be dynamically configured and deployed. Provide common pattern used in distributed system  |
3 | Spring Data | used to access SQL  and NoSQL database |
4 | Spring Integration | it allows enterprise applications to be connected easlity using messaging  |
5 | Spring Batch | used to handle large volumes of data and functionality like ability to restart, ability to read from and write to different systems, chunk processing, parallel processing, and transaction management. |
6 | Spring Security | provides authentication and authorization features |
7 | Spring Session  | supports multiple sessions in a single browser instance, manages session information and makes it easeir to share session data between services in the cloud regardless of the platform/container.  |
8 | Spring Mobile | offers device detection and progressive rendering options that make mobile web application development easy. |
9 | Spring Android | facilitates the development of Android applications |

# Advantages 
* Flexibility and support of integration with other framework <br />
      Spring modules are not dependent on one another and offer a developer the freedom to pick and choose according to the requirements of the application.
      Spring offers its own MVC framework, SpringMVC, it also offers integration with other MVC frameworks. 
* Removes plumbing code  <br />
      Spring removes plumbing code and lets the programmer focus on the application logic.
* Promotes testable code <br />
      Spring framework enables writing testable code. It offers good integration with JUnit and Mockito frameworks, which lets us write unit tests quickly and easily. The core feature of Spring is dependency injection and if it is used properly, writing unit tests for the code becomes very easy.
* Up to date and adopt lateset technology trends  <br />
      Spring is able to stay current and adapt to changes in development. For example, microservices and cloud services have evolved in the last decade. Spring has come up with projects to keep up with the trend, like Spring Boot, which helps with designing microservices

# Spring basics

## Creating a Project
Earlier building a new spring project was quite hard, we had to decide all maven dependency to use, 
set up the configuration for xml or java, install the tomcat server etc. 

Spring boot comes up with very good new feature and quick setup to start new project. 
Spring boot is actually a spring framework along with embedded servers. it removes the need for 
XML Configuration. 

    Spring Boot ===> Spring Framework  + Embedded server - Manual configuration

Spring initializr can be used to create a spring boot project , where we can simply select the dependencies and create
a basic project structure with maven/gradle build specification. project can be downloaded a zip and can be imported in 
different IDEs like Eclipse or Intellij etc

When the import process finishes, the following hierarchy can be seen:

* src/main/java where the Java code will be written.
* src/main/resources where the application properties are written.
* src/test/java where the tests will be written.

The Maven Dependencies folder lists all the dependencies. Spring has automatically been added as a dependency. Spring-boot, spring-context, spring-beans, and spring-core can also be seen among other dependencies autowired by the Spring Initializr.

# Managing Beans and Dependency 

we have created objects of RecommenderImplementation class and two classes implementing the Filter interface. We are binding the objects together in the constructor. Our code is now loosely coupled as we are passing the name of the filter to be used as a constructor argument.

Spring automates the above process of creating objects and binding them together. It takes the responsibility of creating instances of classes and binding instances based on their dependencies. The instances or objects that Spring manages are called beans. To manage objects and dependencies, Spring requires information about three things:

* Beans
* Dependencies
* Location of beans

Spring uses annotation for managing beans and its dependency
#### @Component
- using this would let Spring create and manage objects
  we want Spring to manage objects of RecommenderImplementation and ContentBasedFilter only, so we will add the @Component annotation at two places in the code:
  
        import org.springframework.stereotype.Component;
        
        @Component
        public class RecommenderImplementation {
        //…
        }

        import org.springframework.stereotype.Component;
        
        @Component
        public class ContentBasedFilter implements Filter {
        //…
        }
The Spring container will have two beans, one of type <I>RecommenderImplementation</I> and the other of type <I>ContentBasedFilter</I>.
![img_1.png](docs/SpringBeansDependency.png)
#### @Autowired
- Now Spring needs to know is the dependencies of each object. 
  The @Autowired annotation is used for this purpose
  
  In our application, the <I>ContentBasedFilter</I> class is a dependency of the <I>RecommenderImplementation</I> class.

        import org.springframework.stereotype.Component;
        import org.springframework.beans.foctory.annotation.Autowired;
        
        @Component
        public class RecommenderImplementation {
        
            @Autowired
            private Filter filter;
            // ...
        }

The @Autowired annotation tells Spring that <I>RecommenderImplementation</I> needs an object of type Filter. 
In other words, <I>Filter</I> is a dependency of <I>RecommenderImplementation</I>.

![img.png](docs/SpringBeans.png)

#### @ComponentScan
Now, Spring requires from the developer is the location of the beans so that it can find them and autowire the dependencies
The @ComponentScan annotation is used for this purpose. This annotation can be used with or without arguments. It tells Spring to scan a specific package and all of its subpackages. In our case, all the files that contain beans are in the same package, com.gn.springbasics, so we want Spring to do a component scan on this package.

Since we are using Spring Boot, 
it uses the @SpringBootApplication annotation in the MovieRecommenderSystemApplication file. 
This annotation is equivalent to the following three annotations:
* <B>@Configuration</B>, which declares a class as the source for bean definitions
* <B>@EnableAutoConfiguration</B>, which allows the application to add beans using classpath definitions
* <B>@ComponentScan</B>, which directs Spring to search for components in the path specified

        @SpringBootApplication = #Configuration + @EnableAutoConfiguration + @ComponentScan

#### @SpringBootApplication
this tells Spring to scan all the files in the package where the class with this annotation is present. 
It also scans any sub-packages of the package where it is placed.

When we use the above mentioned annotations, the following line in our code becomes redundant as it is automatically done by Spring:

        RecommenderImplementation recommender = new RecommenderImplementation(new ContentBasedFilter());

The beans that Spring creates are managed by the Application Context. 
We can get information about a bean from the Application Context. 
The run method returns the ApplicationContext, which can be assigned to a variable appContext. 
Then the getBean method of ApplicationContext can be used to get the bean of a particular class. 
We will create a local variable recommender and assign the bean to it as follows:

        ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
        
        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
        
        String[] result = recommender.recommendMovies("ABC");

Instead of us having to create an instance of the RecommenderImplementation class, Spring Application Context creates the beans. We can simply pick it up from there and use it to execute the RecommendMovies method.

This might look complex to a beginner, but consider for a moment an application that has hundreds of beans, each having a number of dependencies. The fact that we do not have to explicitly create beans and manually wire in the dependencies makes the job of a developer very easy.


To understand what goes on in the background, we will run the application in debug mode. 
This can be done by changing the <I>application.properties</I> file in <I>src/main/resources</I>.

        Logging.level.org.springframework = debug

A summary of the actions is reproduced below:
* Loading source class...<br>
  The package is being searched. Spring starts with a component scan to find anything with @Component as well as other annotations
  
* Identified candidate component class...<br>
  Spring identifies two candidates which have the @Component annotation as we only used it in two places in our code.
  
* Creating shared instance...<br>
  Spring starts creating instances of the beans. 
  It creates beans that do not have any dependency first.<br>
  
      Creating shared instance of singleton bean 'movieRecommenderSystemApplication'
      Creating shared instance of singleton bean 'contentBasedFilter'
  
* Now Spring can autowire the dependency using the constructor that we have provided and creates the RecommenderImplementation bean.
        
        Creating shared instance of singleton bean 'recommenderImplementation'
        Autowiring by type from bean name 'recommenderImplementation' via constructor to bean named 'contentBasedFilter'

To better understand these annotations, play around with the code below and see what error messages Spring throws when some of the annotations are missing. The error message can be found at the end of the log.


## Autowire in-depth By Type : @Primary

In the last lesson, we saw Spring manage two beans of the RecommenderImplementation and ContentBasedFilter classes for us. In this lesson, we will add another bean and see how Spring can dynamically choose a bean if it finds two matches of the same type.

1. Add the @Component annotation on the CollaborativeFilter class to declare it a bean. Now both implementations of the Filter interface are beans. Previously, when Spring searched for a dependency to be autowired in the RecommenderImplementation object, it only found one bean of matching type. Now when we run the application, it fails to start.
![img.png](docs/SpringDependencyConflicts.png)

        org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.gn.springbasics.mrs.Filter' available: expected single matching bean but found 2: collaborativeFilter,contentBasedFilter
        
        Parameter 0 of constructor in com.gn.springbasics.mrs.RecommenderImplementation required a single bean, but 2 were found:
        - collaborativeFilter: defined in file [C:\Users\Anuja\IdeaProjects\spring-example\movie-recommender-system\target\classes\com\gn\springbasics\mrs\CollaborativeFilter.class]
        - contentBasedFilter: defined in file [C:\Users\Anuja\IdeaProjects\spring-example\movie-recommender-system\target\classes\com\gn\springbasics\mrs\ContentBasedFilter.class]
        
        Action:
        Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

2. One way Spring can choose between two beans of the same type is by giving one bean priority over the other. The @Primary annotation is used for making a component the default choice when multiple beans of the same type are found.
   Using @Primary is called autowiring by type. We are looking for instances of type Filter.
   
3. If we make both beans primary by adding the @Primary annotation to both implementations of the Filter interface, we will get an error, This happens because Spring doesn't know which one to inject in the RecommenderImplementation object. The error message states “more than one 'primary' bean found among candidates: [collaborativeFilter, contentBasedFilter]”.

## Autowire in-depth By Name 
Let's look at another autowiring approach known as autowiring by name and see which approach has higher priority; by name or by type.

Another approach is autowiring by name where we specify the bean that is to be used by name. In this approach, while creating an object, the dependency is injected by matching the name of the reference variable to the bean name. The developer has to ensure that the variable name is the same as its bean name.
1. We will begin by omitting the @Primary annotation from the CollaborativeFilter class. Now to let Spring know which bean to use, change the variable name in the RecommenderImplementation class to match the bean name as follows:

        @Autowired
        private  Filter contentBasedFilter;

Now when the application is run, it chooses the ContentBasedFilter bean for autowiring. When Spring finds two beans of the same type (Filter), it determines that the bean to inject is the one whose name matches the one used with the @Component annotation for that bean. In other words, the variable name (contentBasedFilter) matches the bean name (ContentBasedFilter).

2. As an exercise, let’s see what happens if the bean name and variable names are different. Let's change the name of the variable to filterObj.

When the application is run, autowiring does not take place.

3. We have seen two autowiring approaches so far. To see which autowiring approach takes precedence, we will use the @Primary annotation on ContentBasedFilter class and use autowiring by name by changing the name of the variable of type Filter in RecommenderImplementation class to collaborativeFilter.
   The application chooses a content-based filter, showing that @Primary has a higher priority.

This is because @Autowired annotation tries to resolve dependency by type first. If it fails to resolve a conflict and finds more than one bean of the same type then it tries to resolve it by name.

The autowiring by name approach is advantageous when we want to use one bean in one situation and another bean in some other situation. Using @Primary will always give preference to one bean, which is impractical if we want to use different beans in different scenarios.

## Autowiring In-depth: @Qualifier
Let's examine the @Qualifier annotation for autowiring and compare it to @Primary.

### @Qualifier
Like @Primary, the @Qualifier annotation gives priority to one bean over the other if two beans of the same type are found. The bean with the @Qualifier annotation qualifies to be injected as a dependency. The @Qualifier annotation can be used in a scenario when we have multiple objects of the same type and autowiring by name cannot be used because the variable name doesn't match any bean name.

1. We will use the name CBF for ContentBasedFilter. Add the @Qualifier annotation in two places, the RecommenderImplementation class where the dependency is defined, and the ContentBasedFilter class.

        @Autowired
        @Qualifier("CBF")
        private  Filter filter;
   
        ..............
   
        @Component
        @Qualifier("CBF")
        public  class ContentBasedFilter implements Filter{
        //...
        }

2. We can add the @Qualifier annotation on the CollaborativeFilter class too. Let’s give this bean the name CF.

        @Autowired
        @Qualifier("CF")
        private  Filter filter;
   
        ....................
   
        @Component
        @Qualifier("CF")
        public  class CollaborativeFilter implements Filter{
        //...
        }

This time, the CollaborativeFilter bean qualifies to be autowired. Depending upon which filter is required in a given scenario, we can change the @Qualifier annotation in the RecommenderImplementation class.

### Comparison with @Primary 
The @Qualifier annotation takes precedence over the @Primary annotation. 

@Primary annotation should be used if there is one clear favorite to be used in a majority of situations. In some cases, one algorithm might be more efficient or more important than the rest and is declared as the primary choice. The bean with @Primary gets chosen unless another bean is required, which can be specified with @Qualifier. The bean with @Qualifier is only used to request an "alternate" bean in case the primary choice is not required.

@Autowired annotation resolves dependencies by type. If there are more than one beans of the same type, a conflict arises. We have seen three different approaches to resolve conflicts. They can be resolved using the @Primary annotation, renaming the variable to match the name of the class, or by using the @Qualifier annotation


## Constructor and Setter Injection