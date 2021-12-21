package ru.mirea.tourismapp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.tourismapp.repo.ProductRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Order> listAll(String keyword) {
        if (keyword != null) {
            return repo.findAll(keyword);
        }
        return repo.findAll();
    }

    public void save(Order order){
        repo.save(order);
    }
}
