package org.example.mainmicroservice.service;

import org.example.mainmicroservice.domain.dto.BookDTO;

public interface BookCommandService {
    boolean addNewBook(BookDTO book);
    void takeBook(Long id);
    void returnBook(Long id);
    void updateBook(Long id, BookDTO updateBook);
    void deleteBook(Long id);

}

