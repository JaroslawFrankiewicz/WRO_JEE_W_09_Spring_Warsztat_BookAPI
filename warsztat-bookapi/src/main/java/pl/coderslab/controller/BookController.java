package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.services.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public @ResponseBody
    List<Book> getlist() {
        return bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> findBook(@PathVariable("id") long id) {
        Optional<Book> book = bookService.findBook(id);
        return ResponseEntity.ok().body(book);
    }
//    @RequestMapping("/{id}")
//    public Optional<Book> findBook(@PathVariable("id") Long id, Model model) {
//        Optional<Book> book = bookService.findBook(id);
//        model.addAttribute("book", book);
//        return Optional.ofNullable(this.bookService.findBook(id).orElseThrow(() -> {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "entity not found");
//        }));
//}









    
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public String handleHttpMediaTypeNotAcceptableException() {
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }
}
