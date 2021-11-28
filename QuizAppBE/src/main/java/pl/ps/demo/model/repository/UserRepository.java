package pl.ps.demo.model.repository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.ps.demo.exception.MyCustomException;
import pl.ps.demo.model.entity.Role;
import pl.ps.demo.model.entity.User;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

public interface UserRepository extends AbstractJpaRepository<User> {

    User findUserById(Long id);

    User findByEmail(String email);

    Optional<User> findByUserName(String userName);

    Boolean existsByEmail(String email);

    Boolean existsByUserName(String userName);

    List<User> findUserByRolesEquals(Role role);

    default User findByUserNameOrThrow(String userName) {
        notNull(userName, "Username is null");
        return findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Użytkownik "+ userName + " nie istnieje!"));
    }
}
