package ru.mirea.tourismapp.domain;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;

    public User toUser(PasswordEncoder passwordEncoder) {
       User user = new User();
       user.setEmail(email);
       user.setPassword(passwordEncoder.encode(password));
       user.setPhone(phone);
       user.setUsername(username);
       user.setRoles(Collections.singleton(Role.USER));
       user.setName(name);
       return user;
    }
}
