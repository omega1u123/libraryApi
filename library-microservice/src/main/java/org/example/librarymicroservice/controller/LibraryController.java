package org.example.librarymicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.librarymicroservice.service.LibraryCommandServiceImpl;
import org.example.librarymicroservice.service.LibraryQueryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryQueryServiceImpl libraryQueryService;
    private final LibraryCommandServiceImpl libraryCommandService;

    @PostMapping("/addBook/{id}")
    public ResponseEntity<?> addBook(@PathVariable Long id){
        libraryCommandService.addBook(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/getFreeBooks")
    public ResponseEntity<List<Long>> getFree(){
        return ResponseEntity.ok(libraryQueryService.getFreeBooks());
    }

    @PostMapping("/takeBook/{id}")
    public ResponseEntity<?> takeBook(@PathVariable Long id){
        libraryCommandService.takeBook(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/returnBook/{id}")
    public ResponseEntity<?> returnBook(@PathVariable Long id){
        libraryCommandService.returnBook(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        libraryCommandService.deleteBook(id);
        return ResponseEntity.status(200).build();
    }

}
