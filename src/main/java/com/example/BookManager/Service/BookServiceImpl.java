package com.example.BookManager.Service;

import com.example.BookManager.DAO.BookDAO;
import com.example.BookManager.Model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDAO.addBook(book);
    }

    @Transactional
    @Override
    public void updateBook(Book book) {
        this.bookDAO.updateBook(book);
    }

    @Transactional
    @Override
    public void removeBook(int id) {
        this.bookDAO.removeBook(id);
    }

    @Transactional
    @Override
    public Book getBookById(int id) {
        return this.bookDAO.getBookById(id);
    }

    @Transactional
    @Override
    public List<Book> listBooks() {
        return this.bookDAO.listBooks();
    }
}
