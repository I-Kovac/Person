package online.shop.person.service;


import online.shop.person.model.Person;
import online.shop.person.repository.PersonRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private PasswordEncoder encoder= new BCryptPasswordEncoder();
    private PersonRepository userRepo;

    public TokenService(PersonRepository userRepo) {
        this.userRepo = userRepo;
    }
    public String generateToken(Person user){
        user.setToken(encoder.encode(user.getEmail()));
        user.setTokenLifetime(System.currentTimeMillis()+60*10*1000);

        userRepo.save(user);
        return  user.getToken();
    }
    public String generatePassword(String rawPassword){
        return encoder.encode(rawPassword);
    }
}
