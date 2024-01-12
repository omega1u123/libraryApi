/*package org.example.mainmicroservice.service;

import lombok.RequiredArgsConstructor;
import org.example.mainmicroservice.domain.dto.BookDTO;
import org.example.mainmicroservice.domain.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final ModelMapper modelMapper;
    private final BookQueryServiceImpl bookQueryService;
    private final BookCommandServiceImpl bookCommandService;

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> books = bookQueryService.findAll();
        if(!books.isEmpty()){
            return books.stream()
                    .map(item -> modelMapper.map(item, BookDTO.class))
                    .toList();
        }else return null;
    }

    @Override
    public BookDTO getBookById(Long id) {
        if(bookQueryService.findBookEntityById(id) != null){
            return modelMapper.map(bookQueryService.findBookEntityById(id), BookDTO.class);
        }else return null;
    }

    @Override
    public BookDTO getBookByIsbn(String isbn) {
        if(bookQueryService.findBookEntityByIsbn(isbn) != null){
            return modelMapper.map(bookQueryService.findBookEntityByIsbn(isbn), BookDTO.class);
        }else return null;
    }

    @Override
    public void addNewBook(BookDTO book) {
        bookCommandService.addNewBook(book);
    }

    @Override
    public void updateBookInfo(Long id, BookDTO updateBook) {
        bookCommandService.updateBook(id, updateBook);
    }

    @Override
    public void deleteBook(Long id) {
       bookCommandService.deleteBook(id);
    }
}
*/