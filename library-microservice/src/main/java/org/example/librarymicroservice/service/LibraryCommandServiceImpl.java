package org.example.librarymicroservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.librarymicroservice.domain.entity.BookEntity;
import org.example.librarymicroservice.domain.dao.BookRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibraryCommandServiceImpl implements LibraryCommandService{

    private final BookRepo bookRepo;
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void addBook(Long id) {
        log.info("" + id);
        bookRepo.save(new BookEntity(id, "", ""));
    }

    @Override
    public void takeBook(Long id) {
        if (bookRepo.findById(id).isPresent()) {
            BookEntity book = bookRepo.findById(id).get();
            book.setTakenTime(LocalDateTime.now().format(formatter));
            book.setReturnRime(LocalDateTime.now().plusWeeks(2).format(formatter));
            bookRepo.save(book);
        }
    }

    @Override
    public void returnBook(Long id) {
        if (bookRepo.findById(id).isPresent()) {
            BookEntity book = bookRepo.findById(id).get();
            book.setTakenTime("");
            book.setReturnRime("");
            bookRepo.save(book);
        }
    }

    @Override
    public void deleteBook(Long id) {
        if (bookRepo.findById(id).isPresent()) {
            bookRepo.deleteById(id);
        }
    }
}
