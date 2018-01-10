# Homer Consulting Web Service

We did a small project in our *Database Management* course where we had to create a database, insert data, and run several 
fairly complex queries. I decided to brush-up my [Spring](https://projects.spring.io/spring-boot/) knowledge and used data from that project to create a web service.
It was fun, and learned new things too along the way!

### Steps to Run Locally

This webs service is built using [Spring Boot](https://projects.spring.io/spring-boot/) and the build tool is 
[Gradle](https://gradle.org/). However, you don't need to have *Gradle* installed. *Gradle wrapper* is included with the project
which can be used to download the necessary libraries and build the project. 

#### 1. Setup database in MySQL

Create a database with the name `homerconsulting` in MySQL.
Don't create tables manually, they'll be generated once you run the application.

Edit the `src/main/resources/application.properties` file to reflect the username and password of your MySQL setup.

```
spring.datasource.username = some_username
spring.datasource.password = some_password
```

#### 2. Clone the repository

```
git clone https://github.com/shantanu27/homer_consulting_service.git
```

#### 3. Build and run the application

With the database setup, and code ready, you can now build and run the application! From your project directory, run:

```
./gradlew clean build
java -jar build/libs/homerconsulting-0.0.1-SNAPSHOT.jar 
```
It should be able to run and compile without any issue. Make sure to have your MySQL server running and `application.properties`
file is correctly configured.

#### 4. Add data to the database

Once you run the application for the first time, it should also generate the tables in the database. But you can't really test
the endpoints since there's no data. 
I have included a file `SQL_Data.txt` in the project folder. You can import data into your database using that file. 

### Test Endpoints

I have written some basic endpoints currently which can be tested in [Postman](https://www.getpostman.com/). Some of the endpoints are:

```
http://localhost:8080/hc/employees/
http://localhost:8080/hc/employees/{id}/
http://localhost:8080/hc/employees/supervisor/100
```

These are just some of the GET apis. You can check more apis in the *Controller* classes. 
