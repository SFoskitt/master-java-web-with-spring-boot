# Master Java Web Services and REST API with Spring Boot
https://www.coursera.org/learn/packt-master-java-web-services-and-rest-api-with-spring-boot-mxnmc/home/module/1

**NOTE**: when you did the guided project a couple days ago, you had trouble running the project in Eclipse unless you commented out the test code that came with initializer. In this project there are no issues at all -- **AND** -- I think this is because you changed the JDK in the initializer to JDK 21, and I did this because my version of Eclipse 2025-03 (4.35.0) only goes to JDK 21.


2025-07-01 @ 12:39:09 - STARTING THIS COURSE TODAY - setting a time limit on this of 1.5 hours for today - how far can I get?

## Step 00 - Intro to web services

W3C "Web Service" - 1. interoperable (not platform dependent)  2. machine to machine  3. over a network

Request and Response are expected methods of communication between web service and client - SHOULD ALSO BE PLATFORM-INDEPENDENT

Data (Message) Exchange Formats - XML and JSON

Service definition - how requests and responses should be formatted - what are the endpoints - the contract between provider and consumer

Service Provider (hosts the service) and Service Consumer (client)

Transport - how a service is called? - examples: HTTP (internet) or MQ (queueing technology)

SOAP vs REST

    SOAP - simple object access protocol - structured XML request and response
        - WSDL - web service definition language - Envelope, Header, Body
        - service definition *IS* required

    REST - represational state transfer - Roy Fielding
        - think in terms of resources
        - think in terms of HTTP verbs
        - TRANSPORT IS ALWAYS HTTP
        - WADL - web application definition language
        - Swagger - defines API
        - architectural style
        - no strict data exchange format, could be JSON or XML or something else
        - service definition NOT required

HTTP - GET, PUT, POST - responses include HTTP codes

URI - uniform resource identifier



## Step 01 - Getting started with Spring

Important terms: Tight Coupling, Loose Coupling, IOC Container, Application Context, Component Scan, Dependency Injection, Spring Beans, and Auto Wiring

  - iteration 1 - game runner class and separate game classes - TIGHTLY COUPLED
  - iteration 2 - interfaces == LOOSE COUPLING
  - iteration 3 - Spring framework - LOOSE COUPLING LEVEL 2


ECLIPSE NOTE: it doesn't or won't find the Java 24 installed here so I re-downloaded the Spring initializer with Java 21 and it now seems happy to import the project and run it (maybe update it later)

Iteration 1 -
  - MarioGame class instatiated in GameRunner
  - then SuperContra game could not be run in there without revising code
  - TIGHTLY COUPLED

Iteration 2 - 
  - GamingConsole.java creates an interface which contains the actions: up, down, left, rightand 
  - the games MarioGame and SuperContra both extend the interface
  - now pass GamingConsole to GameRunner
  - BUT does not solve the issue of switching games in main fun

Iteration 3 -
  - GamingConsole class IS A DEPENDENCY of GameRunner class
  - we are creating both manually in main class
  - let Spring Framework manage these dependencies
  - Autowire pulls together the @Component classes to the @Autowired definitions?
  - Autowire wires DEPENDENCIES
  - Spring manages all these in "Application Context"
  - SpringApplication.run in main tells spring to manage these
  - Spring application context manages "beans"
  - REMOVE MANUAL INSTANCE CREATION of GameConsole (game) and GameRunner
  - any instance of any @Component is a "bean"
  - replace three simple lines with two, more complex, lines


## Step 09

@ComponentScan happens automatically with @SpringBootApplication but you can add it manually to scan multiple packages - in our example it is * package and *.game package - by adding them as an array
`@ComponentScan({"com.package1", "com.package2"})`

Spring is called a DI - dependency injection - framework
Dependency Injection is called "inversion of control" because Spring is in control
Spring Beans - object managed by Spring Framework
IoC container - manages the lifecycle of beans and dependencies
Two types of IoC container - 1. bean factory, 2. application context


## Step 10

LAYERS
Higher to lower, higher dependent on lower:
  - web
  - business
  - data
  - database

Mark components using annotations -
- @Component
- @Service
- @Repository
Wire together with @Autowire

MyWebController.java > BusinessService.java > DataService.java demonstrates how dependencies are nested and annotating these with @Component and @Autowired allows Spring to manage all of these.


## Step 11

Autowire matches only one component, so in our game example then how to manage three games with one Autowire? 
Label one as @Primary


## Step 12 - Spring framework - Maven

Spring has jar dependencies and each of these have dependencies - TRANSITIVE DEPENDENCIES
Introduces Maven and pom.xml
Maven requires a file structure and this structure is used by vast majority of Java projects
Clarification between Maven dependencies and Spring dependencies - THIS TRIPPED YOU UP IN THE PAST


## Step 13 - exploring spring framework dependency injection types

Constructor-based - dependencies are set by creating a bean using its constructor
Setter-based - dependencies set by getters/setters
Field - no getters/setters or constructor, dependency injected by reflection

Spring recommends Constructor-based injection because the Autowire can happen at the time the object is created (object creation due to the constructor)
"So just with one constructor initialization, your entire object is ready for use. You don't really need to worry about whether something is Autowired or not." -- MAYBE DON'T NEED AUTOWIRED ANNOTATION IN THIS CASE? because he removed it in his example

When using constructor-based injection then you can add Autowired to both the constructor and on the field


## Step 14 - exploring Spring modules

Spring modules -
  - Core (IoC container, etc.)
  - Testing (mock objects, Spring MVC test, etc.)
  - Data Access (transactions, JDBC, JPA, etc.)
  - WebServlet (Spring MVC, etc.)
  - WebReactive (Spring WebFlux, etc.)
  - Integration (Spring JMS ) - talking to other applications or a queue


## Step 15 - exploring Spring projects

Spring Boot - most popular for microservices
Spring Cloud - cloud native applications
Spring Data - integrate the same way with different types of databases
Spring Integration - address challenges integrating with other applications
Spring Security - secure the application or REST API or microservice

Spring keeps evolving (REST API > Microservices > Cloud)


## Step 16 - getting started with Spring framework

very very brief overview


## QUIZ

notes from the quiz - 

- interface facilitates polymorphic behavior and flexibility

- constructor injection ensures dependencies are immutable

- Java 17 minimum required for Spring Boot 3


==============================

# MODULE 4 - apparently

==============================

NOTE: 

## Step 01 - Getting Started with Spring Boot - Goals

1. Understanding the world before Spring Boot
2. Create a Spring Boot Project
3. Build a simple REST API with Spring Boot
4. Understand the magic of Spring Boot
   1. Spring Initializr
   2. Starter projects
   3. Auto configuration
   4. Developer tools
   5. Actuator


## Step 02 - understanding the world before Spring Boot - 10,000 feet overview

Things were harder to manage because there were so many requirements including non-functional requirements:
  - logging
  - error handling
  - monitoring

Before Spring, managing all this manually:
1. dependency management (pom.xml)
2. define webapp configuration (web.xml)
3. manage spring beans (context.xml)
4. implement non-functional requirements
AND - repeat this for all projects

Very time intensive
Very manual 


## Step 03 - setting up new spring boot project with spring initializr

The usual routine.


## Step 04 - build a hello, world API with Spring Boot

Add request (GET) routes with @RequestMapping("/route")


## Step 05 - understanding the goal of Spring Boot

Spring Boot == 
1. build production ready applications
  - logging
  - different configs per environment (profiles)
  - monitoring (Spring Boot actuator)
2. quickly
   - Spring Initializr
   - Spring Boot Starter Project
   - Spring Boot Auto Config
   - Spring Boot dev tools


## Step 06 - understanding Spring Boot magic - starter projects

More about dependencies. In the pom.xml you can do Cmd + click on a package dependency and it will open an expanded version of the highlighted package.

More narrative about Spring starter projects and dependencies.

1. Spring Boot starter projects are convenient dependency descriptors
2. Spring Boot provides a variety of starter projects


## Step 07 - understanding Spring Boot magic - autoconfiguration

Spring auto configs with package `org.springframework.boot.autoconfigure.web`
application.properties configs again (logging)
`spring-boot-autoconfigure.jar` - copy class from logs - open a class with Cmd + Shift + T - paste classname

NOTE: in Eclipse, use double arrow icon in Package Explorer to see where the class lives in the project - in this case it was `DispatcherServletAutoConfiguration` and because it's a Spring dependency package it opens in the Maven Dependencies folder

DispatcherServletAutoConfiguration is annotated with `@ConditionalOnWebApplication` so it runs during web applications


## Step 08 - build faster with Spring Boot dev tools

Increase developer productivity
Restart server automatically for code change including application.properties - EXCEPT - changes to pom.xml require application stop/start


## Step 09 - get production ready with spring boot - 1 - profiles

Production ready with application configuration with profiles, i.e. Dev, QA, Stage, Prod
  - managed in application.properties

`spring.profiles.active=<env>` in main `application.properties` and it will "merge" props in that environment's app.props
Profile props, i.e. `application-dev.properties`  will take priority - so if you have:
app-dev.props = logging.level.org.springframework=debug
app-prod.props = logging.level.org.springframework=info
app.props = logging.level.org.springframework=trace
Debug logging should happen when `spring.profiles.active=dev`

Logging levels = trace, debug, info, warning, error, and off



## Step 10 - get production ready with spring boot - 2 - configuration properties

PROVING THE CONFIG PROPS CAN BE PUSHED UP - app.props > ConfigService > ConfigController
Annotation = @ConfigurationProperties at the class level in the service AND
Annotation = @Component at the class level in the service AND
Annotation = @Autowired at the field level in the controller

SEARCH - FIND = ctrl + H  NOTE: this is not "win ctrl = mac cmd" - this is literally mac ctrl ^

app.props and profiles combined are powerful


## Step 11 - get production ready with spring boot - 3 - embedded servers

Simplifying Deployment with Spring Boot embedded servers

OLD WAY =
1. install java
2. install web application/server
3. deploy WAR application

NEW WAY = 
the server is embedded in the build so:
1. install java
2. run jar

`mvn clean install` on terminal and in Eclipse right click "Run As" > "Maven Build" > type "clean install" in "Goals" field

Embedded server exmaples:
`spring-boot-starter-tomcat`
`spring-boot-starter-jetty`
`spring-boot-starter-undertow`

From Baeldung and Spring:
> Tomcat, Jetty, and Undertow are all embedded servlet containers used in Spring Boot applications, each with its own strengths. Tomcat is widely used and well-supported, Jetty is known for its lightweight and asynchronous capabilities, while Undertow offers high performance and flexibility, especially for handling non-blocking requests.


## Step 12 - get production ready with spring boot - 4 - actuator

requires additional package called `spring-boot-starter-actuator`
`localhost:8080/actuator` shows health of server generally
HOWEVER - the default, without config, is just `*/health` and nothing more
ADD - `management.endpoints.web.exposure.include=*` to get a bunch more health 

`http://localhost:8080/actuator/configprops`
`http://localhost:8080/actuator/env`
`http://localhost:8080/actuator/metrics`
    - this is a base url for the metrics in the list it produces, i.e. `http://localhost:8080/actuator/metrics/application.started.time`

0	"/actuator/metrics/{requiredMetricName}"
1	"/actuator"
2	"/actuator/configprops"
3	"/actuator/beans"
4	"/actuator/health"
5	"/actuator/health/**"
6	"/actuator/metrics"
7	"/**"
8	"/actuator/env"

THIS COULD BE RESOURCE INTENSIVE - so consider limiting the exposed actuator endpoints, i.e.:
`management.endpoints.web.exposure.include=heath,metrics`


## Step 13 - understanding Spring Boot vs Spring vs MVC

Spring Framework = dependency injection (@Component, @Autowired, component scan)
  - dependency injection alone is not enough, you need other frameworks to build apps
  - @Component, @Autowired

Spring MVC - simplify building web apps with REST API
  - building web apps with Struts was difficult 
  - @Controller, @RequestMapping("/courses"), @RestController

Spring Boot - build production-ready applications quickly
  - Starter projects - make it easy to build a variety of applications
  - Auto configuration - eliminate configurations to set up Spring, Spring MVC, and other frameworks
  - enable non-functional requirements
      - Actuator - enables advanced monitoring of applications
      - Embedded server - no need for separate application servers
      - Logging and Error handling
      - Profiles and Config props

SPRING BOOT IS A WRAPPER FOR SPRING MVC AND SPRING FRAMEWORK


## Step 14 - getting started with Spring Boot review


## QUIZ

==============================

# MODULE 5 - Introduction to Maven

==============================

## Step 01 - Introduction to Maven
- create new projects
- manage dependencies
- build a jar file
- run application locally
- run unit tests
- deploy to test env


## Step 02 - Creating a Spring Boot Project with Maven

This familiar file structure is a MAVEN file struct - if it's Gradle or no package manager then files could be organized any old way


## Step 03 - Exploring Maven pom.xml for Spring Boot project

Cmd + Click on a pom.xml dependency to open that dependency's pom.xml

"Transitive dependencies" - these are the dependencies of dependencies of dependencies... etc.

Maven manages dependencies automatically (actually, based on my experience, it depends on the IDE - not on Maven)

In Eclipse you can see the "Dependency Hiearchy" tab at the bottom of each pom.xml, even the dependency pom files

NOTE: Maven dependencies and Spring dependencies are NOT the same thing


## Step 04 - Exploring Maven Parent pom for Spring Boot project

Concept of parent pom - includes depends and some configs (like artifact id and java version)

Get a unified, single file pom of all the dependencies in any Maven project with goal: `help:effective-pom`
Get this same unified pom in Eclipse two ways:
1. Right click > "Run As" > "Maven build..." > goal = `help:effective-pom`
2. pom.xml > tabs at the bottom include "Effective pom" 
1 and 2 above should generate identical files.

`spring-boot-starter-parent` includes depends as well as the two depends in our pom.xml also have their own depdends

Effective pom includes the versions of AAALLLL the depends

Dependency Management section is where depends are defined


## Step 05 - Exploring Maven Further

Pom defines:
- Name of our project -- groupId + artifactId
  1. groupId similar to package name
  2. artifactId similar to class name
  3. important so it can be published to m2 for others to use/download

ACTIVITY: define goals

`mvn dependency:tree` produces a dependency/hierarchy tree
In Eclipse: right click > "run as" > "maven build..." > goal = `dependency:tree`


## Step 06 - Exploring Maven Bild Lifecycle with a Spring Boot Project

`mvn install` runs a sequence of steps
    - copies resources
    - compiling module
    - compiling test files
    - tests are run
    - build a jar file `/Module5-0.0.1-SNAPSHOT.jar`


## Step 07 - How does Maven work?

Pre-defined folder structure 
  - useful when moving from one project to another 
  - convention 
  - standard structure

Maven central repository 
  - the place where all the jars live - https://mvnrepository.com
  - ANY of the jars in the dependency tree can be found here 
  - located under their group id and artifact id

Spring Milestones is a RC version - it is a dependency in the tree but NOT available in the Maven central - this is downloaded from the URL provided in the `<dependency>` block with a `<url>` property

Additional blocks in the pom.xml are `<repositories>` and `<pluginRepositories>`

"Local Maven Repository" -- All downloaded jars are stored in your local Maven directory called `m2` under `/Users/<user>/`


## Step 08 - Playing with Maven Commands

`mvn --version`

`mvn compile` -- compile only -- one of the many steps in `mvn install`

`mvn test-compile` -- compile test files - but will also compile source files

`mvn clean` -- cleans out target folder

`mvn test` -- runs unit tests

`mvn package` -- create the jar file

`mvn help:effective-pom` -- creates a single, unified pom file of AAALLL dependencies

`mvn dependency:tree` -- the dependency hierarchy tree


## Step 09 - How are Spring Projects Versioned?

Spring Releases - MAJOR.MINOR.PATCH[-MODIFIER]
ex: 4.1.5 == Major version = 4, Minor version = 1, Patch version = 5

How does Spring decide when to update a Major or Minor version?
    - Significant amount of work to upgrade = major version update 
    - Little to no work to upgrade = minor version update
    - No work to upgrade = patch version update
    - Optional modifier - "Release", "RC" (RC1, RC2, ...), "Milestone" (M1, M2, ...), "Snapshot"
Who decides what is "major" or "minor"?

Example versions in order:
10.0.0-SNAPSHOT, 10.0.0-M1, 10.0.0-M2, 10.0.0-RC1, 10.0.0-RC2, 10.0.0....

Recommend: 
- Avoid Snapshot version
- Use only release versions in production


## Managing projects with Maven (dialogue with ai)

## Introduction to Maven - Assessment - Graded Assignment


==============================

# MODULE 6 - Introduction to Gradle

==============================

## Step 01 - Getting started with Gradle

- Build anything - cross platform tool
  - Java, C/C++, JS, Python

- Automate everything - completely programmable
  - Complete flexibility
  - Uses a DL - supports Groovy and Kotlin

- Deliver Faster - blazing fast builds
  - Complie avoidance to advanced caching
  - Can speed up Maven builds by up to 90%
    - incrementality - gradle runs only what is necesary
    - builde cache - reuses the build outputs of other gradle builds with the same inputs

- Same project layout as Maven

- IDE support still evolving 


## Step 02 - Creating a Spring Boot Project with Gradle

`settings.gradle` file, `build.gradle` file, (and maybe `gradlew` file?) are the critical files here
`build.gradle` contains the dependencies

`rootProject.name = ...` is the artifact id

Gradle configuration is simpler than Maven pom.xml

Eclipse does not automatically download new/updated depends in the build.gradle file, must be done manually 


## Step 03 - Exploring Gradle Build and Settings Files

Key task: build
 - setting up a gradle task using Eclipse - it's lengthy and looks ridiculous

Gradle build:
    - similar to mvn install - many smaller tasks are included in the process like...
    - `compileJava`
    - `processResources`
    - `classes`
    - `resolveMainClassname`
    - `bootJar`
    - `jar`
    - and many, many more...

Build directory is "build" 
- build artifacts and test artifacts are here 
- generated code 
- libraries 
- reports


## Step 04 - Exploring Gradle Plugis for Java and Spring Boot

TOP 3 JAVA PLUGINS FOR GRADLE
    1. Java plugin 
      - java compilation and testing and building capabilities
      - Default layout
        - identical to maven

    2. Dependency management - maven-like dependency management
        - add a new dependency with the group id, artifact id, version as a shortcut:
        - `implementation 'org.springframework:spring-core:10.0.3.RELEASE'`

    3. Spring Boot Gradle Plugin
       - Spring Boot support in Gradle
       - package executable Spring Boot jar, container image (boot.jar, bootBuildImage)
       - use dependency management enabled by spring-boot-dependencies
         - no need to specify dependency version


## Step 05 - Maven or Gradle - which one to use for Spring Boot projects?

Popular examples:
- spring framework - using gradle since 2012
- spring boot - using gradle since 2020
- spring cloud - continues to use maven even today

Top maven advantages -
    - familiar
    - simple
    - restrictive (pom.xml)

Top gradle advantages -
    - faster build times
    - less verbose
    - flexible (build.gradle)
        - adding tasks is easy - it looks like adding a task to package.json
        - add stuff in groovy and in groovy add using Java because Java is valid in groovy
        - write programs and add them as part of the build

What do I recommend: He's sitting on the fence for now
    - choose whatever tool best meets your projects needs
    - if your builds are simple, stick with maven



==============================

# MODULE 7 - SOAP Web Services with Spring and Spring Boot

==============================

## Step 00 - SOAP web services, an overview


## Step 01 - Initialize a Spring web services application with spring boot


## Step 02 - Overview of creating SOAP web service using contract first approach


## Step 03 - Define request and response structure with XML


## Step 04 - Define XML schema definition (XSD) for Request - GetCourseDetailsRequest


## Step 05 - Define XML schema definition (XSD) for Response - GetCourseDetailsResponse


## Step 06 - More about XML schema definition and implementing XSD best practices


## Step 07 - Introduction to Java API for XML binding (JAXB) and configuring JAXB


## Step 08 - Configuring an endpoint for GetCourseDetailsRequest


## Step 09 - Spring web services configuration - message dispatcher servlet


## Step 10 - Spring web services configuration - generating WSDL


## Step 11 - Using wizdler to execute SOAP requests


## Step 12 - Implementing a service - course details service - backend with memo


## Step 13 - Implementing SOAP web service for GetAllCourseDetailsRequest


## Step 14 - Quick introduction to different parts of a WSDL


## Step 15 - Implementing SOAP web service for DeleteCourseDetailsRequest


## Step 16 - Improving the DeleteCourseDetailsRequest


## Step 17 - Exception handling and SOAP fault responses


## Step 18 - Implementing security for SOAP web services with ws security


## QUIZ



==============================

# MODULE 8 - RESTful Web Services with Spring and Spring Boot

==============================

## Step 00 - Creating a rest api with SB

- why spring boot?
- how to build a great rest api?
  - how to identify resources
  - identifying actions
  - defining request and response structures
  - using appropriate response status
  - rest api best practices

1. Build 3 simple hellow world rest api
  - understand the magic of spring boot
  - understand fundamentals of building rest api with spring boot

2. build a rest api for social media application
  - design and build a great rest api
    - choosing the right uri for resources (/users, /users/{id}, /users/{id}/posts)
    - choosing the right request method for actions (GET, POST, PUT, DELETE)
    - designing request and response structures
    - implementing security, validation and exception handling
  - build advanced rest api features
    - internationalization, HATEOAS, versioning, documentation, content negotiation

3. connect your rest api to a database
   - fundamentals of JPA and hibernate
   - use H2 as an in memory database


## Step 01 - initializing a rest api project with spring boot


## Step 02 - Creating a Hello World REST API with Spring Boot

NOTE: for some reason the Spring Boot Devtools was not reloading on changes to this file - tried almost all of these things:
https://stackoverflow.com/questions/39738901/how-do-i-activate-a-spring-boot-profile-when-running-from-intellij
https://intellij-support.jetbrains.com/hc/en-us/community/posts/4404522882450-Spring-Boot-DevTools-Live-Reload-Not-Working


create a new package then add a new java class HelloWorldController.java

Spring annotation on the method in this controller is:
```java
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
```
This can be simplified to:
```java
  @GetMapping(path = "/hello-world")
```
THIS WILL CHANGE THE IMPORTS AS WELL


## Step 03 - Enhancing the Hellow World REST API to return a Bean

Add a new bean to return from path /hello-world-bean which resolves in the browser as a JSON object


## Step 04 - What's happening in the background? Spring Boot Starters and Autoconfign

Why did Spring return a JSON object?

1. how are our requests handled?
   - DispatcherServlet - front controller pattern - routes requests to the right controller
   - Mapping servlets - dispatcherServlet urls = [/]
   - Auto Configuration (DispatcherServletAutoConfiguration)

2. How does HelloWorldBean get converted to JSON?
  - `@ResponseBody` + `JacksonHttpMessageConverters`
    - `@RestController` annotation is a combination of multiple other annotations (Cmd + B)
      ```java
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        @Documented
        @Controller
        @ResponseBody
      ```
  - `JacksonHttpMessageConverters` is automatically configured by Spring-Boot to JSON-ify responses

3. Who is configuring error mapping?
  - Auto configuration - `ErrorMvcAutoConfiguration` - produces whitelabel errors and pages

4. How are all jars available (Spring, Spring MVC, Jackson, Tomcat)?
  - because of starter projects and dependencies
  - Spring Boot Starter Web (spring-webmvc, spring-web, spring-boot-starter-tomcat, spring-boot-starter-json)


SERVLET = a servlet is a Java class that extends the capabilities of a server by handling requests and generating responses


## Step 05 - Enhancing the Hello World REST API with a Path Variable

Path Parameters / Path Variables
EX:
  // /users/{id}/todos/{id} => /users/2/todos/10

  path parameter - the value inside the { curly brackets }
  path variable - the value passed to the method managing the route with the path parameter
    i.e. `public String method(@PathVariable String id)`


## Step 06 - Designing the REST API for Social Media Application

- Build a REST API for a social media application
- Key resources:
  - users
  - posts
- Key details:
  - user: id, name, birthDate
  - post: id, description



## Step 07 - Creating User Bean and User DAO Service


## Step 08 - Implementing GET methods for user resource


## Step 09 - Implementing POST method to create user resource





==============================

# MODULE 9 - Introduction to JPA in 12 Steps

==============================





==============================

# MODULE 10 - Connecting RESTful Web Service to JPA

==============================





==============================

# MODULE 11 - RESTful Web Services - Best Practices

==============================





==============================

# MODULE 12 - Congratulations

==============================



==============================

# MODULE 13 - APPENDIX - Java New Features - A Quick Review using Q&A format

==============================


==============================

# MODULE 14 - Appendix - Introduction to Functional Programming in 30 minutes

==============================
