package nguyenhoangthinh.quanlysachCSDLlap3.entity;

import jakarta.persistence.*;

import nguyenhoangthinh.quanlysachCSDLlap3.validator.annotation.ValidUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "User is required ")
    @Size(max = 50, message = "Username must be less than 50 characters")
    @ValidUsername
    private String username;

   @Column(name ="password", length =250 , nullable = false)
   @NotBlank(message ="Password is required ")
       private String password ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Column(name ="email", length =50)
 @Size(max =50 , message =" Email must be less than 50 charaters")
 @Email(message ="Email should be valid ")
    private String email ;

    @Column(name = "name", length = 50, nullable = false)
    @Size(max  =50, message ="Your name must be less than 50 charaters ")
    @NotBlank(message ="Your name is required ")
    private String name ;
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

}
