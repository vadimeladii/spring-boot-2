# Spring Boot 2 Example Project
This is a sample Java / Gradle / Spring Boot (version 2.0.4) application. 

Spring Boot makes it easy to create Spring-powered, production-grade applications and services with absolute minimum 
fuss. It takes an opinionated view of the Spring platform so that new and existing users can quickly get to the bits 
they need. You can use Spring Boot to create stand-alone Java applications that can be started using java -jar or more 
traditional WAR deployments.

# How to Run

This application is packaged as a war which has Tomcat 8.5 embedded. No Tomcat, Jetty or JBoss installation is necessary.
You run it using the java -jar command.

* Clone this repository
* Make sure you are using JDK 1.8 and PostgreSQL started on port 5432
* You can build the project running ./gradlew clean build
* Once successfully built, you can run the service by 

<pre>
    java -jar /webservice/build/libs/webservice-0.0.1-SNAPSHOT.jar
</pre>

Once the application runs you should see something like this

<pre>
    2018-09-01 12:51:59.725  INFO 14803 --- [main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    2018-09-01 12:51:59.728  INFO 14803 --- [main] m.s.w.c.core.SpringBoot2Application      : Started SpringBoot2Application in 5.36 seconds (JVM running for 5.876)
</pre>


You can also use Docker for running application. 

Download Docker. If you are on Mac or Windows, Docker Compose will be automatically installed. On Linux, make sure you 
have the latest version of Compose. If you're using Docker for Windows on Windows 10 pro or later, you must also switch 
to Linux containers.

Run in this directory:

<pre>
    docker-compose up
</pre>

Then you can see:

<pre>
Starting springboot2_db_1 ... done
Starting springboot2_spring_boot_1 ... done
Attaching to springboot2_db_1, springboot2_spring_boot_1
...
</pre>


Here is the docker-compose.yml that powers the whole setup.

<pre>
    version: '2'
    services:
    # POSTGRES
        db:
            image: postgres:latest
            restart: always
            environment:
                POSTGRES_PASSWORD: postgres
    # SPRING_BOOT APPLICATION
        spring_boot:
            image: vadimeladii7/springboot2:latest
            ports:
                - "8080:8080"
            links:
                - db
            depends_on:
                - db
            environment:
                - SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/postgres
                - SPRING_DATASOURCE_USERNAME=postgres
                - SPRING_DATASOURCE_PASSWORD=postgres
                - SPRING_FLYWAY_URL=jdbc:postgresql://db:5432/postgres
                - SPRING_FLYWAY_USER=postgres
                - SPRING_FLYWAY_PASSWORD=postgres
</pre>


