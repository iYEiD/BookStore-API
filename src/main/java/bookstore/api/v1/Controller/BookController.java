package bookstore.api.v1.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bookstore.api.v1.Service.BookService;
import bookstore.api.v1.Model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/test")
    public String test() {
        return "Test Passed";
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBookID(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllBooks() {
        bookService.deleteAllBooks();
    }

    @GetMapping("/paged/{page}/{size}/{sortField}/{sortOrder}")
    public ResponseEntity<List<Book>> getAllBooks(@PathVariable int page, @PathVariable int size,
            @PathVariable String sortField, @PathVariable String sortOrder) {

        Page<Book> bookPage = bookService.getAllBooks(page, size, sortField, sortOrder);

        List<Book> books = bookPage.getContent();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Total-Count", String.valueOf(bookPage.getTotalElements()));
        responseHeaders.set("X-Page-Number", String.valueOf(bookPage.getNumber()));
        responseHeaders.set("X-Page-Size", String.valueOf(bookPage.getSize()));

        return new ResponseEntity<>(books, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/searchtitle/{title}")
    public List<Book> searchBooksTitled(@PathVariable String title) {
        return bookService.searchBooksTitled(title);
    }

    @GetMapping("/searchauthor/{author}")
    public List<Book> searchBooksAuthored(@PathVariable String author) {
        return bookService.searchBooksAuthored(author);
    }

}