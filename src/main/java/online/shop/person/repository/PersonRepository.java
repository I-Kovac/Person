package online.shop.person.repository;

import online.shop.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByToken(String token);

    Person findByEmailAndPassword(String email, String password);
}
