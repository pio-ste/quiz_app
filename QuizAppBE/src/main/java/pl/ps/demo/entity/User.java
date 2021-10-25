package pl.ps.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "quiz_app",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_name", "email"}, name = "UQ_fields")})
public class User extends IdField{

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns={@JoinColumn(name="id.user")},
            inverseJoinColumns={@JoinColumn(name="id.role")},
            foreignKey = @ForeignKey(name = "fk_user"),
            inverseForeignKey = @ForeignKey(name = "fk_role"))
    private Collection<Role> roles = new ArrayList<>();

    public User(Long id, String userName, String password, String firstName, String lastName, String email, Collection<Role> roles) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
