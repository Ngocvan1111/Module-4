package com.example.excercise.model;

import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contract")
public class Contract {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int code;

    @ManyToOne
    @JoinColumn(name = "id_book",referencedColumnName = "id")
    private Book book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
