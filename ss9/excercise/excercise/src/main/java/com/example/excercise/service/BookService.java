package com.example.excercise.service;

import com.example.excercise.model.Book;
import com.example.excercise.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        int amount = book.getAmount()-1;
        book.setAmount(amount);
        System.out.println(book.getAmount());
        iBookRepository.save(book);
    }
}
