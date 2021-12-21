package ru.mirea.tourismapp.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.tourismapp.domain.User;

public interface UserRepo extends CrudRepository<User,Long> {
    User findByUsername(String name);

}
