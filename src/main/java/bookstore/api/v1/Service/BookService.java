package bookstore.api.v1.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import bookstore.api.v1.Model.Book;
import bookstore.api.v1.Repository.BookRepository;

@Service
public class BookService {
   
@Autowired    
private BookRepository bookRepository;

@GetMapping("/books")
public List<Book> getAllBooks() {

    if (bookRepository.findAll().isEmpty()) {
        return null;
    }
    return bookRepository.findAll();

}
//for pagination
public Page<Book> getAllBooks(int page, int size, String sortField, String sortOrder) {
    Sort.Direction direction = Sort.Direction.ASC;
    if (sortOrder.equalsIgnoreCase("desc")) {
        direction = Sort.Direction.DESC;
    }
    
    Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));
    return bookRepository.findAll(pageable);
}






public Optional<Book> getBookById(String id) {
    Optional<Book> bookOptional = bookRepository.findById(id);

    if (bookOptional.isPresent())  return bookOptional;
    else return null;
    
    
}

// public List<Book> searchBooksTitled(String title) {
//     return bookRepository.findByTitle(title);
// }
// public List<Book> searchAuthorBooks(String author) {
//     return bookRepository.findByAuthor(author);
// }

public Book addBook(Book book) {
    if (bookRepository.findById(book.getId()).isPresent()) return null;
    if(book.getTitle().isEmpty() || book.getAuthor().isEmpty() || book.getPrice() <=0 || book.getStock() < 0 ) return null;
    book.setAvailability();
    return bookRepository.save(book);
}

public Book updateBook(String id, Book book) {
    if (bookRepository.findById(id).isEmpty()) return null;
    bookRepository.deleteById(id);
    return bookRepository.save(book);
}

public void deleteBookID(String id) {
    if (bookRepository.findById(id).isEmpty()) return;
    bookRepository.deleteById(id);
}
// public void deleteBookTitled(String title) {
//     bookRepository.deleteByTitle(title);
// }

public void deleteAllBooks() {
    if(bookRepository.findAll().isEmpty()) return;
    bookRepository.deleteAll();
}





}
