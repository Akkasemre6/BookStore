package Repository.business;

import Entity.business.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book getById(Long id);


}
