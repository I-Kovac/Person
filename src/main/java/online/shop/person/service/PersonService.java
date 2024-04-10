package online.shop.person.service;

import online.shop.person.model.Person;
import online.shop.person.repository.PersonRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository repo;

    private PasswordEncoder encoder= new BCryptPasswordEncoder();

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person getUserByToken(String token) {
        return repo.findByToken(token);
    }
    public Person getUserbyEmailAndPassword(String email, String password){
        return repo.findByEmailAndPassword(email, password);
    }
    public Person save(Person person) {
       return repo.save(person);
    }
}
