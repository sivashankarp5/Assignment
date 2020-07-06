# Assignment

A Spring Boot web application example, using embedded Tomcat, JSP template + RESTful service, and package as an executable WAR file.

Features :

  - RESTful Service to list all files and subdirectories in a particular directory
  - RESTful Service to list file attributes of a particular file
  - Spring MVC with JSP for front end
  - Unit tests for testing the business logic
  


# Assumptions!

  - RESTful service is deployed in Windows environment and provided directoryPath,filePath are in Windows Specific format
  - 


To Improve:
  - More Frot end customization/decoration can be done
  - Add more validations
  - Add more Tests


### Tech

Dillinger uses a number of open source projects to work properly:

* Spring Boot 2.3.1.RELEASE
* Spring 5.2.7.RELEASE
* Tomcat Embed 9.0.36
* Maven 3
* Java 8
* Junit 5.6.2
* Mockito 3.3.3
* SLF4J 1.7.3

  
And of course DemoApp itself is open source with a [public repository][dill]
 on GitHub.

### Installation

DemoApp uses IntelliJ to run.

Maven refresh and Rebuild project after all dependencies are resolved.



For production OR any environments...

```sh
Run the FundamentalsApplication annotated with SpringBootApplication
```


### Development

Want to contribute? Great!

DemoApp uses SpringBoot + Maven for fast developing.
Make a change in your file and instantaneously see your updates!

Open your favorite Terminal and run these commands to Maven package the project as an executable WAR file and run the app.

```sh
$ mvn spring-boot:run
$ mvn clean package
```

### Todos

 - Write MORE Tests
 - Add More Front end code

License
----

MIT


**Free Software!**
