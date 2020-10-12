package com.example.BookManager.DAO;

import com.example.BookManager.Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookDAOimpl  implements BookDAO {
    private static final Logger logger = LoggerFactory.getLogger(BookDAOimpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Добавленеи успешно!:)");
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Информация о "+book+" успешно обновленна");
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));

        if(book != null){
            session.delete(book);
        }

        logger.info(book+"успешно удалена");
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class,new Integer(id));
        logger.info("Книга успешно загружена"+ book);

        return book;

    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Book> listBooks() {
        Session session = sessionFactory.getCurrentSession();

        List<Book> bookList = session.createQuery("from Book").list();

        for (Book book: bookList){
            logger.info("Список книг: "+ book);
        }
        return bookList;
    }
}
