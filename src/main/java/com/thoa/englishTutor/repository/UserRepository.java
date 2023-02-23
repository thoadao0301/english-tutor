package com.thoa.englishTutor.repository;

import com.thoa.englishTutor.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    public boolean existsByEmail(String email);
}
