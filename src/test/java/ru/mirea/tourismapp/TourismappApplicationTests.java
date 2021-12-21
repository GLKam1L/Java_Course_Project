package ru.mirea.tourismapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mirea.tourismapp.controller.HomeController;
import ru.mirea.tourismapp.controller.RegistrationController;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TourismappApplicationTests {

    @Autowired
    private HomeController homeController;

    @Autowired
    private RegistrationController registrationController;

    @Test
    void contextLoads() throws Exception{
        assertThat(homeController).isNotNull();
        assertThat(registrationController).isNotNull();
    }

}