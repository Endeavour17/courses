package kg.megacom.courses.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String fio;
    private String login;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
