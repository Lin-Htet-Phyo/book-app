package com.example.myapp.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        book.setCategory(this);
        bookList.add(book);
    }
}
