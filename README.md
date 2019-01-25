# JLReducedPricedProductsApi

# Products in Category - Reduced Price Products Service

This service is used to return a list of products in category 600001506 that have a price reduction. The service returns an array of products showing those products with the greatest price reduction first.

## Getting Started

This project was developed using Intellij so the below instructions will refer to this IDE and help you to set-up the project and run the tests. The steps will be very similar for other IDEs.

### Prerequisites

This application requires a fully functioning version of Java8. Ensure that Java8 has been installed and configured in your environment's path and ideally setup
with a JAVA_HOME environment variable. The application also uses, GradleW, Junit and Mockito. If you haven't got these installed then make sure you have a
working internet connection as once the project starts to load up GradleW will attempt to resolve any missing dependencies by downloading any missing executables. You will also
need to be able to issue the Git commands to download and install a copy of the code

### Installing

Create a new project directory on your local PC and from there issue the below "git clone" command to download and create a local repository for the project.  
C:\PATH_TO_DIR\>git clone "https://github.com/robbie70/JLReducedPricedProductsApi.git"  

## Running the tests

The tests can be executed from inside the IDE. From inside Intellij navigate to the Project folder,  
/src/test/java  
and right-click the folder and select the pop-out option "run all tests". This will then execute all the tests in the test suite.

## Starting the Application
In Intellij, navigate to the Project folder,  
/src/main/java/com.zensar.tech/app  
and right-click the class "Application" and select the option "Run Application.main()" wait until the application has started. The log entries should be error free and the last entries show show something similar to the below with application hosted by Tomcat at port 8080,  
2019-01-25 17:06:58.122  INFO 18056 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''  
2019-01-25 17:06:58.122  INFO 18056 --- [           main] com.zensar.techtest.app.Application      : Started Application in 3.491 seconds (JVM running for 4.157)  
2019-01-25 17:07:38.177  INFO 18056 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'  
2019-01-25 17:07:38.177  INFO 18056 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'  
2019-01-25 17:07:38.184  INFO 18056 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 7 ms  

## Calling the Application from a web browser
The application can  be called from the following urls,  
"http://localhost:8080/api/600001506/getreducedproductslist?labelType=ShowWasNow",
"http://localhost:8080/api/600001506/getreducedproductslist?labelType=ShowWasThenNow",
"http://localhost:8080/api/600001506/getreducedproductslist?labelType=ShowPercDscount" or
"http://localhost:8080/api/600001506/getreducedproductslist"  

## Built With

* [Gradle](https://gradle.org/) - Build Tool

## Versioning

We use [SemVer](http://semver.org/) for versioning.

Assumptions:  
1. Price.now  
This field received via the JSON API can have two value types, String or Object. For the String, the value represents a numerical value e.g. "59.00". For the Object type, the value represents an object of form,  
"from" : "50.00"  
"to"   : "100.00"  
The instructions for the test didn't specify how to handle this situation when the value is represented as an Object so the assumption made here has been to take an average of the two values, "from" and "to" and return a single value representing this average.  

2. Currency Symbol  
I have created a map for storing currency symbols, GBP -> "£" but a visual inspection of the data showed that all the products returned from the API are in GBP so in theory I could hard code "£" for all prices but I didn't feel comfortable to do this so I retained my map
for now and made an assumption that if the look-up to the currency map fails to match then rather than failing the call I would default to "£".  
  
3. PriceLabel  
If an alternative parameter value is specified (i.e. a value not mentioned in the specification), the system will default to ShowWasNow.  
## Authors

* **Robert Stannard** - *developer*
