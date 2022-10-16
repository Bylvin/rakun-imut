package mega.itdp.bookauthor.controller;

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

import mega.itdp.bookauthor.entity.Person;
import mega.itdp.bookauthor.repository.PersonRepository;

@RestController
@RequestMapping(value="persons")
public class PersonController
{
	private final Log log = LogFactory.getLog(PersonController.class);
	
	@Autowired
	private PersonRepository personRepository;

	// Select All
	@GetMapping
	public List<Person> selectAll() {
		log.info("Log: SHOW ALL PERSON...");
		return personRepository.findAll();
	}
	
	// Select One
	@GetMapping("/{id}")
	public Person selectOne(@PathVariable Long id) {
		log.info("Log: SHOW PERSON WITH ID: " + id);
		return personRepository.findById(id).get();
	}

	// Add
	@PostMapping
	public Person create(@RequestBody Person person)
	{
		person.setCreatedAt(new Date());
		log.info("Log: ADD PERSON WITH ID: " + person.getId());
		return personRepository.save(person);
	}

	// Edit
	@PutMapping("/{id}")
	public Person update(@RequestBody Person person, @PathVariable Long id)
	{
		Person existing = personRepository.findById(id).get();
		existing.setId(person.getId());
		existing.setVersion(person.getVersion());    
		existing.setName(person.getName());   
		existing.setModifiedAt(new Date());

		log.info("Log: EDIT PERSON WITH ID: " + id);
		return personRepository.save(existing);
	}

	// Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		log.info("Log: DELETE PERSON WITH ID: " + id);
		personRepository.deleteById(id);
	}
}
