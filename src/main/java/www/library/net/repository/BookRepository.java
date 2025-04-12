package www.library.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www.library.net.entity.Book;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

       Book findByDeletedFalseAndUuid(UUID uuid);
}
