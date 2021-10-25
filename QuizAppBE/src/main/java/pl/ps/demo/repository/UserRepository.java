package pl.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ps.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
