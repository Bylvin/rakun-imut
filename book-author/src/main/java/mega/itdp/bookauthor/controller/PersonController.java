package mega.itdp.bookauthor.controller;

import java.util.List;

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
import mega.itdp.workplace.entity.Weight;

@RestController
@RequestMapping(value="persons")
public class PersonController
{
	@Autowired
	private PersonRepository personRepository;

	// Add
	@GetMapping
	public List<Person> list() {

		return personRepository.findAll();
	};

	@PostMapping
	public Person create(@RequestBody Person person)
	{
		return personRepository.save(person);
	};

	@GetMapping("/{id}")
	public Person findOne(@PathVariable Long id) {

		return personRepository.findById(id).get();
	};

	@PutMapping("/{id}")
	public Person update(@RequestBody Person person, @PathVariable Long id)
	{
		Person existing = personRepository.findById(id).get();
		existing.setId(person.getId());
		existing.setVersion(person.getVersion());    
		existing.setName(person.getName());   

		return personRepository.save(existing);
	};

	// Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		personRepository.deleteById(id);
	};
}
