package pl.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ps.demo.entity.Role;
import pl.ps.demo.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findByEmail(String email);

    User findByUserName(String userName);

    List<User> findUserByRolesEquals(Role role);
}
