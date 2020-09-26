package pl.coderslab.services;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ApiBookService implements BookService {

    private static Long nextId = 4L;

    private List<Book> books;

    public ApiBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L,"9788324631766","Thiniking in Java","Bruce Eckel","Helion","programming"));
        books.add(new Book(2L,"9788324627738","Rusz glowa Java.","Sierra Kathy, Bates Bert","Helion","programming"));
        books.add(new Book(3L,"9780130819338","Java 2. Podstawy","Cay Horstmann Gary Cornell","Helion","programming"));
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        ApiBookService.nextId = nextId;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public Optional<Book> findBook(long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

}
