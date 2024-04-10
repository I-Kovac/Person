package online.shop.person.controller;

import online.shop.person.dto.Request.*;
import online.shop.person.model.Person;
import online.shop.person.service.PersonService;
import online.shop.person.service.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;
    private final TokenService tokenService;



    public PersonController(PersonService personService, TokenService tokenService) {
        this.personService = personService;
        this.tokenService = tokenService;
    }

    @GetMapping("/person/{token}")
    public Person PersonResponseDto(@PathVariable String token) {
        return personService.getUserByToken(token);
    }

    @GetMapping("/person/login")
    public String login(@RequestBody PersonRequestLoginDTO p){
        Person person =personService.getUserbyEmailAndPassword(p.email(),tokenService.generatePassword(p.password()));

        if (person!=null){
            return tokenService.generateToken(person);
        } else {
            return null;
        }
    }

    @PostMapping("/person/create")
    public Boolean createUser(@RequestBody PersonRequestDto p) {
        Person person = new Person(p.firstName(), p.lastName(), tokenService.generatePassword(p.password()), p.email());
        if (personService.save(person) != null) {
            return true;
        } else {
            return false;
        }
    }


    @PutMapping("/person/update")
    public Boolean updateUser(@RequestBody PersonRequestDto p){
        Person person = new Person(p.firstName(),p.lastName(),tokenService.generatePassword(p.password()),p.email());
        if (personService.save(person)!=null){
            return true;
        } else {
            return false;
        }
    }





}
