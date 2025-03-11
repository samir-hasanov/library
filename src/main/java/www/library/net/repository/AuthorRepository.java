package www.library.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www.library.net.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
