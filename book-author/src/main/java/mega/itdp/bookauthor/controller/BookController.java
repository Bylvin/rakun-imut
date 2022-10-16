package mega.itdp.bookauthor.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mega.itdp.bookauthor.entity.Book;
import mega.itdp.bookauthor.entity.Person;
import mega.itdp.bookauthor.repository.BookRepository;
import mega.itdp.bookauthor.repository.PersonRepository;
import mega.itdp.bookauthor.result.BookResult;

@RestController
@RequestMapping(value="books")
public class BookController
{
	private final Log log = LogFactory.getLog(BookController.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PersonRepository personRepository;

	// Select all
	@GetMapping
	public List<BookResult> list()
	{
		List<Book> selectAll = bookRepository.findAll();
		List<BookResult> results = new ArrayList<>();

		for (Book book : selectAll) {
			results.add(new BookResult(book));
		}

		log.info("Log: SHOW ALL BOOKS...");
		return results;
	};

	// Select one
	@GetMapping("/{id}")
	public BookResult findOne(@PathVariable Long id)
	{
		Book selectOne = bookRepository.findById(id).get();
		BookResult result = new BookResult(selectOne);

		log.info("Log: SHOWING BOOK = " + id);
		return result;
	}

	// Show based on Author
	@GetMapping("/authorId={authorId}")
	public List<BookResult> showAllByAuthor(@PathVariable Long authorId)
	{
		List<Book> selectAllByAuthorId = bookRepository.findAllByAuthorId(authorId);
		List<BookResult> results = new ArrayList<>();

		for (Book book : selectAllByAuthorId) {
			results.add(new BookResult(book));
		}

		log.info("Log: SHOW ALL BOOKS BY AUTHOR_ID = " + authorId);
		return results;
	};

	// Add
	@PostMapping
	public BookResult add(@RequestBody BookResult bookResult)
	{
		Person author = null;
		if (bookResult.getAuthorId() != null) {
			author = personRepository.findById(bookResult.getAuthorId()).get();
		}
		Book book = bookResult.backToEntity(bookResult);
		book.setAuthor(author);
		book.setCreatedAt(new Date());
		
		log.info("Log: ADD BOOK WITH ID: " + book.getId());
		return new BookResult(bookRepository.save(book));
	}

	// Edit
	@PutMapping("/{id}")
	public BookResult edit(@RequestBody BookResult bookResult, @PathVariable Long id)
	{
		Person author = null;
		if (bookResult.getAuthorId() != null) {
			author = personRepository.findById(bookResult.getAuthorId()).get();
		}
		Book book = bookRepository.findById(id).get();
		
		book.setId(bookResult.getId());
		book.setVersion(bookResult.getVersion());
		book.setTitle(bookResult.getTitle());
		book.setPrice(bookResult.getPrice());
		book.setAuthor(author);
		book.setModifiedAt(new Date());
		
		log.info("Log: EDIT BOOK WITH ID: " + book.getId());
		return new BookResult(bookRepository.save(book));
	}

	// Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		log.info("Log: DELETE BOOKS WITH ID: " + id);
		bookRepository.deleteById(id);
	}
}
