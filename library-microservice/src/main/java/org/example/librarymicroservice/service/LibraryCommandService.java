package org.example.librarymicroservice.service;

public interface LibraryCommandService {
    void addBook(Long id);

    void takeBook(Long id);

    void returnBook(Long id);

    void deleteBook(Long id);
}
