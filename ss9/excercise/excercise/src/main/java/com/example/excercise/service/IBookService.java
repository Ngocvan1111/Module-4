package com.example.excercise.service;

import com.example.excercise.model.Book;

public interface IBookService extends IGeneralService<Book> {
    void save(Book book);
}
