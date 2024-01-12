package org.example.mainmicroservice.service;

import org.example.mainmicroservice.domain.dto.BookDTO;

import java.util.List;

public interface BookQueryService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO getBookByIsbn(String isbn);

    List<BookDTO> getFreeBooks();
}
