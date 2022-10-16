package mega.itdp.bookauthor.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mega.itdp.bookauthor.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>
{
	List<Book> findAllByAuthorId(Long id);
}
