package pl.coderslab.services;

import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Book;


public class MemoryBookService {
    private static Long nextId = 4L;

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }











//    //Save the record
//    long save(Book book);
//
//    //Get a single record
//    Book get(long id);
//
//    //Get all the records
//    List<Book> list();
//
//    //Updat the record
//    void update(long id, Book book);
//
//    //Delete a record
//
//    void delete(long id);

}
