package com.example.BookManager.DAO;

import com.example.BookManager.Model.Book;

import java.util.List;

public interface BookDAO {

    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> listBooks();
}
