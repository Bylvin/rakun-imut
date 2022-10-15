package mega.itdp.bookauthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mega.itdp.bookauthor.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
