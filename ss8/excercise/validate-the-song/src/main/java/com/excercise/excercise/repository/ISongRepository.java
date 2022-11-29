package com.excercise.excercise.repository;

import com.excercise.excercise.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
