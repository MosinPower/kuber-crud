package com.github.mosinpower.kubercrud.repo;

import com.github.mosinpower.kubercrud.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveUser() {

        User user = new User();
        user.setEmail("some@mail.ru");
        user.setUsername("some_name");
        user.setPhone("12345678");
        user.setFirstName("First");
        user.setLastName("Last");
        User savedUser = userRepository.save(user);

        User retrievedUser = userRepository.findAll().stream().findFirst().get();

        Assertions.assertAll("user saved",
                () -> assertEquals(user.getUsername(), retrievedUser.getUsername()),
                () -> assertEquals(user.getUsername(), savedUser.getUsername()));
    }

}