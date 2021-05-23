package ru.mirea.tourismapp.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.tourismapp.domain.Order;

public interface OrderRepo extends CrudRepository<Order,Long> {

    Order findOrderById(Long id);
    Iterable<Order> findAllByUserId(Long id);
    Iterable<Order> findAllByCountryAndStatus(String country, boolean status);
}
