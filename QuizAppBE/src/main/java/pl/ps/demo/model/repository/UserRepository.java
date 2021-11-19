package pl.ps.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;
import pl.ps.demo.model.entity.Answer;
import pl.ps.demo.model.entity.Role;
import pl.ps.demo.model.entity.User;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.*;

public interface UserRepository extends AbstractJpaRepository<User> {

    User findUserById(Long id);

    User findByEmail(String email);

    Optional<User> findByUserName(String userName);

    List<User> findUserByRolesEquals(Role role);

    default User findByUserNameOrThrow(String userName) {
        notNull(userName, "Username is null");
        return findByUserName(userName).orElseThrow(() -> new EntityNotFoundException("There is no entity for name: " + userName));
    }
}
