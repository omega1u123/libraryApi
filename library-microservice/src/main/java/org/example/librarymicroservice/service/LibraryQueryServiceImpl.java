package org.example.librarymicroservice.service;

import lombok.RequiredArgsConstructor;
import org.example.librarymicroservice.domain.entity.BookEntity;
import org.example.librarymicroservice.domain.dao.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryQueryServiceImpl implements LibraryQueryService{

    private final BookRepo bookRepo;
    public List<Long> getAllBooks() {
        return ((List<BookEntity>) bookRepo.findAll()).stream()
                .map(BookEntity::getId)
                .toList();
    }

    @Override
    public List<Long> getFreeBooks() {
        return ((List<BookEntity>) bookRepo.findAll()).stream()
                .filter(item -> item.getTakenTime().isEmpty())
                .map(BookEntity::getId).toList();
    }
}
