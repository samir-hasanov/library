package www.library.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www.library.net.entity.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader,Long> {
}
