package ru.mirea.tourismapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.tourismapp.domain.Order;
import ru.mirea.tourismapp.domain.User;
import ru.mirea.tourismapp.repo.OrderRepo;
import ru.mirea.tourismapp.repo.UserRepo;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;
    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model){
        if (user!= null){
            model.addAttribute("user",user.getUsername());
            return "index";
        }

        model.addAttribute("user","anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/foruser")
    public String forUser() {
        return "foruser";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/foradmin")
    public String forAdmin() {
        return "foradmin";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        Iterable<Order>orders=orderRepo.findAllByStatus(false);
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/reserve")
    public String reserve(@RequestParam Long id, @AuthenticationPrincipal User user, Model model){
        Order order = orderRepo.findOrderById(id);
        order.setStatus(true);
        orderRepo.save(order);
        user.setOrderId(order.getId());
        userRepo.save(user);
        return "redirect:/orders";
    }

    @GetMapping("/maldives")
    public String  maldives() {
        return "maldives";
    }
}

