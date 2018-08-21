package ru.spring.library.dao;

import org.springframework.stereotype.Component;
import ru.spring.library.entities.Author;
import ru.spring.library.entities.Book;
import ru.spring.library.entities.Genre;

import java.util.List;

@Component
public interface BookDao {
    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);


}
