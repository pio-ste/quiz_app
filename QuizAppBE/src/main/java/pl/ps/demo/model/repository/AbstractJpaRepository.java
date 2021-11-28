package pl.ps.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityNotFoundException;

import static org.springframework.util.Assert.notNull;

@NoRepositoryBean
public interface AbstractJpaRepository<T> extends JpaRepository<T, Long> {

    long countById(Long id);

    default T getByIdOrThrow(Long id) {
        notNull(id, "Id is null");
        return findById(id).orElseThrow(() -> new EntityNotFoundException("There is no entity for id: " + id));
    }

    default void deleteOrThrow(Long id) {
        notNull(id, "Id is null");
        if (countById(id) == 0) {
            throw new EntityNotFoundException("There is no entity for id: " + id);
        } else {
            deleteById(id);
        }
    }

}
