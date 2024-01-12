package org.example.mainmicroservice.service;

import lombok.RequiredArgsConstructor;
import org.example.mainmicroservice.domain.dao.BookRepo;
import org.example.mainmicroservice.domain.dto.BookDTO;
import org.example.mainmicroservice.domain.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BookCommandServiceImpl implements BookCommandService{

    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Override
    public boolean addNewBook(BookDTO book){
        bookRepo.save(modelMapper.map(book, BookEntity.class));
        ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:8081/addBook/{id}",null, HttpStatus.class, book.getId());
        return response.getStatusCode() == HttpStatus.valueOf(200);
    }

    @Override
    public void takeBook(Long id) {
        ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:8081/takeBook/{id}",null, HttpStatus.class, id);
    }

    @Override
    public void returnBook(Long id) {
        ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:8081/returnBook/{id}",null, HttpStatus.class, id);
    }


    @Override
    public void updateBook(Long id, BookDTO updateBook){
        if(bookRepo.findBookEntityById(id).isPresent())
            bookRepo.save(modelMapper.map(updateBook, BookEntity.class));
    }
    @Override
    public void deleteBook(Long id){
        if (bookRepo.findBookEntityById(id).isPresent()){
            bookRepo.delete(bookRepo.findBookEntityById(id).get());
            ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:8081/deleteBook/{id}",null, HttpStatus.class, id);
        }
    }


}
