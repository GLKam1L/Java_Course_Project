package ru.mirea.tourismapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mirea.tourismapp.domain.Order;

import java.util.List;

public interface ProductRepo extends JpaRepository<Order, Long> {

    @Query("SELECT p FROM Order p WHERE CONCAT(p.city, ' ', p.country, ' ', p.date, ' ', p.orderName) LIKE %?1%")
    public List<Order> findAll(String keyword);
}
