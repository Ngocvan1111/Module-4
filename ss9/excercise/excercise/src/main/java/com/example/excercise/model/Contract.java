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
    private String timeBorrow;
    private String customerName;
    private int code;

    @ManyToOne
    @JoinColumn(name = "id_book",referencedColumnName = "id")
    private Book book;




}
