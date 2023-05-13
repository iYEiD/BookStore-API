package bookstore.api.v1.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import bookstore.api.v1.Model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

        public Book save(Book book);

        public Optional<Book> findById(String id);

        public List<Book> findAll();
        // public List<Book> findByTitle(String title);
        // public List<Book> findByAuthor(String author);

        // public Book updateBook(Book book);

        public void deleteById(String id);

        // public void deleteByTitle(String title);
        public void deleteAll();
}
