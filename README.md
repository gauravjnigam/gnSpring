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

