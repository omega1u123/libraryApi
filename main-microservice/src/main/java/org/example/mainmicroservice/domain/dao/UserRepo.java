package org.example.mainmicroservice.domain.dao;

import org.example.mainmicroservice.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findUserEntityByUsername(String name);
}
