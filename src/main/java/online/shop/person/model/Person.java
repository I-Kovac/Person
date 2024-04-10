package online.shop.person.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Table(name = "t_person")
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
    public final String ROLE_ADMIN="admin";
    public final String ROLE_WORKER="worker";
    public final String ROLE_CUSTOMER="customer";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "token")
    private String token;

    @Column(name = "token_lifetime")
    private long tokenLifetime;

    @Column(name = "role")
    private String role = ROLE_CUSTOMER; //customer is standard role


}
