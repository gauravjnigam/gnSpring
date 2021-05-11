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

** Tight coupling => 
Tightly coupled code involves creating an instance of the dependency inside the class
 
 ---------------------------------------------------------------------------------------
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
 ---------------------------------------------------------------------------------------
 
 Problems can arise when we want to use a different option for the dependency. Suppose if we ClassA wants to rely on different dependency
 This entails changing the code of ClassA, which would be a disadvantage of using tightly coupled code.
