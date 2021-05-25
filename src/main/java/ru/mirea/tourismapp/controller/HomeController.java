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
    public String index(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("user", user.getUsername());
            model.addAttribute("role", user.getRoles());
            model.addAttribute("name", user.getName());
            return "index";
        }

        model.addAttribute("user", "anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login() {


        return "login";
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/user")
    public String forUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        Iterable<Order> orders = orderRepo.findAllByUserId(user.getId());
        model.addAttribute("orders", orders);
        return "user";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/foradmin")
    public String forAdmin() {
        return "foradmin";
    }

    @GetMapping("/orders")
    public String orders(@AuthenticationPrincipal User user, Model model, @RequestParam String country) {
        Iterable<Order> orders = orderRepo.findAllByCountry(country);
        model.addAttribute("orders", orders);
        model.addAttribute("name", user.getName());
        return "orders";
    }

    @GetMapping("/reserve")
    public String reserve(@RequestParam Long id, @AuthenticationPrincipal User user, Model model) {
        Order order = orderRepo.findOrderById(id);
        order.setUserId(user.getId());
        orderRepo.save(order);
        user.setOrderId(order.getId());
        userRepo.save(user);
        return "redirect:/done";
    }

    @GetMapping("/done")
    public String done() {
        return "done";
    }

    @GetMapping("/maldives")
    public String maldives(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {

            model.addAttribute("name", user.getName());
        }
        return "maldives";
    }

    @GetMapping("/usa")
    public String usa(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {

            model.addAttribute("name", user.getName());
        }
        return "usa";
    }

    @GetMapping("/emirates")
    public String emirates(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {

            model.addAttribute("name", user.getName());
        }
        return "emirates";
    }

    @GetMapping("/australia")
    public String australia(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {

            model.addAttribute("name", user.getName());
        }
        return "australia";
    }

    @GetMapping("/india")
    public String india(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {

            model.addAttribute("name", user.getName());
        }
        return "india";
    }

}

