package com.excercise.excercise.service;

import com.excercise.excercise.model.Song;
import com.excercise.excercise.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService{
    @Autowired
    ISongRepository iSongRepository;
    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);

    }

    @Override
    public Optional<Song> findById(Integer id) {
        return iSongRepository.findById(id);
    }
}
