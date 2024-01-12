package org.example.mainmicroservice.domain.dao;

import org.example.mainmicroservice.domain.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findAll();
    Optional<BookEntity> findBookEntityById(Long id);
    Optional<BookEntity> findBookEntityByIsbn(String isbn);

}
