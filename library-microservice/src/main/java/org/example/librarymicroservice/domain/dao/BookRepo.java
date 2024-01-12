package org.example.librarymicroservice.domain.dao;

import org.example.librarymicroservice.domain.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends CrudRepository<BookEntity, Long> {

}
