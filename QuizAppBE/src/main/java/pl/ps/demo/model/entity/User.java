package pl.ps.demo.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends IdField {

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Quiz> quizzes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Participant> participants;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "id_users")},
            inverseJoinColumns = {@JoinColumn(name = "id_roles")})
    private Set<Role> roles;

    public User(Long id, String userName, String password, String firstName, String lastName, String email, Set<Quiz> quizzes, Set<Participant> participants, Set<Role> roles) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.quizzes = quizzes;
        this.participants = participants;
        this.roles = roles;
    }

    public User() {
    }

    public User(UserBuilder userBuilder) {
        super(userBuilder);
        this.userName = userBuilder.userName;
        this.password = userBuilder.password;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.quizzes = userBuilder.quizzes;
        this.participants = userBuilder.participants;
        this.roles = userBuilder.roles;
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

    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static final class UserBuilder extends IdField.Builder<UserBuilder> {
        private String userName;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private Set<Quiz> quizzes;
        private Set<Participant> participants;
        private Set<Role> roles;

        @Override
        public UserBuilder getThis() {
            return this;
        }

        public UserBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder quizzes(Set<Quiz> quizzes) {
            this.quizzes = quizzes;
            return this;
        }

        public UserBuilder participants(Set<Participant> participants) {
            this.participants = participants;
            return this;
        }

        public UserBuilder roles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
