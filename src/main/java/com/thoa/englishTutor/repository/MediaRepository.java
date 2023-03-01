package com.thoa.englishTutor.repository;

import com.thoa.englishTutor.model.Media;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MediaRepository extends CrudRepository<Media, String> {
}
