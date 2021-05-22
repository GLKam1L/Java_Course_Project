package ru.mirea.tourismapp.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.tourismapp.domain.Order;

public interface OrderRepo extends CrudRepository<Order,Long> {

    Iterable<Order> findAllByStatus(boolean status);
    Order findOrderById(Long id);
}
