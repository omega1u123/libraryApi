package org.example.mainmicroservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mainmicroservice.domain.dao.BookRepo;
import org.example.mainmicroservice.domain.dto.BookDTO;
import org.example.mainmicroservice.domain.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BookQueryServiceImpl implements BookQueryService{

    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;
    @Override
    public List<BookDTO> getAllBooks(){
        List<BookEntity> books = bookRepo.findAll();
        if(!books.isEmpty()){
            return books.stream()
                    .map(item -> modelMapper.map(item, BookDTO.class))
                    .toList();
        }else return null;
    }
    @Override
    public BookDTO getBookById(Long id){
        if(bookRepo.findBookEntityById(id).isPresent()){
            return modelMapper.map(bookRepo.findBookEntityById(id), BookDTO.class);
        }else return null;
    }
    @Override
    public BookDTO getBookByIsbn(String isbn){
        if(bookRepo.findBookEntityByIsbn(isbn).isPresent()){
            return modelMapper.map(bookRepo.findBookEntityByIsbn(isbn), BookDTO.class);
        }else return null;
    }

    @Override
    public List<BookDTO> getFreeBooks() {
        ResponseEntity<Long[]> response = restTemplate.getForEntity("http://localhost:8081/getFreeBooks",Long[].class);
        List<Long> ids = Arrays.asList(response.getBody());
        List<BookDTO> books = new LinkedList<>();
        log.info(ids.get(1).toString());
        bookRepo.findBookEntityById(ids.get(1));
        for(Long i : ids){
            log.info(i.toString());
            if(bookRepo.findBookEntityById(i).isPresent())
                books.add(modelMapper.map(bookRepo.findBookEntityById(i).get(), BookDTO.class));
        }
        return books;
    }
}
