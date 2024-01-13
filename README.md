1. создать базу данных
   CREATE DATABASE mainLibraryDB;

    CREATE TABLE UserEntity (
        id SERIAL PRIMARY KEY,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL
    );

    CREATE TABLE BookEntity (
        id SERIAL PRIMARY KEY,
        isbn VARCHAR(20) NOT NULL,
        title VARCHAR(255) NOT NULL,
        genre VARCHAR(50) NOT NULL,
        description TEXT NOT NULL,
        author VARCHAR(100) NOT NULL
    );

    INSERT INTO UserEntity (id, username, password) VALUES (1, 'user', '123');

    CREATE DATABASE libraryDB


2. в mian-microservice и library-microservice изменить логин и пароль к базе данных в application.properties
  
3. порядок запуска:
   1. eureka
   2. main-microservice
   3. library-microservice

4. http://localhost:8080/swagger-ui.html - документация к main-microservice
   http://localhost:8081/swagger-ui.html - документация к library-microservice

Каждый микросервис открывается как отдельный проект 
