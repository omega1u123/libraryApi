package org.example.mainmicroservice.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.example.mainmicroservice.domain.dto.BookDTO;
import org.example.mainmicroservice.service.BookCommandServiceImpl;
import org.example.mainmicroservice.service.BookQueryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class BookController {

    private final BookCommandServiceImpl bookCommandService;
    private final BookQueryServiceImpl bookQueryService;


    @GetMapping("/getBooks")
    public ResponseEntity<List<BookDTO>> getBooks(){
        return ResponseEntity.ok(bookQueryService.getAllBooks());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookQueryService.getBookById(id));
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity<BookDTO> getBookByIsbn(@PathVariable String isbn){
        return ResponseEntity.ok(bookQueryService.getBookByIsbn(isbn));
    }

    @PostMapping("/book/addBook")
    public ResponseEntity<?> addBook(@RequestBody BookDTO book){
        if (bookCommandService.addNewBook(book))
            return ResponseEntity.status(200).build();
        else return ResponseEntity.status(400).body("oops...");
    }

    @PatchMapping("/book/{id}/updateBook")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookDTO book){
        bookCommandService.updateBook(id, book);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/book/{id}/delete")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookCommandService.deleteBook(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/getFreeBooks")
    public ResponseEntity<List<BookDTO>> getFreeBooks(){
        return ResponseEntity.ok(bookQueryService.getFreeBooks());
    }

    @PostMapping("/takeBook/{id}")
    public ResponseEntity<?> takeBook(@PathVariable Long id){
        bookCommandService.takeBook(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/returnBook/{id}")
    public ResponseEntity<?> returnBook(@PathVariable Long id){
        bookCommandService.returnBook(id);
        return ResponseEntity.status(200).build();
    }
}
