package com.github.mosinpower.kubercrud.service;

import com.github.mosinpower.kubercrud.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldCreate() {
        UserDto dto = getDefaultUser();
        UserDto actual = userService.create(dto);
        assertAll("User created",
                () -> assertNotNull(actual.getId()),
                () -> assertEquals(actual.getUsername(), dto.getUsername()));
    }

    @Test
    public void shouldGet() {
        UserDto dto = getDefaultUser();
        UserDto savedUser = userService.create(dto);
        assertNotNull(savedUser);

        UserDto actual = userService.get(savedUser.getId());
        assertAll("Got user",
                () -> assertNotNull(actual),
                () -> assertEquals(actual.getUsername(), dto.getUsername()));
    }

    @Test
    public void shouldDelete() {
        UserDto dto = getDefaultUser();
        UserDto savedUser = userService.create(dto);
        assertNotNull(savedUser);

        userService.delete(savedUser.getId());
        UserDto actual = userService.get(savedUser.getId());
        assertAll("User deleted", () -> assertNull(actual));

    }

    @Test
    public void shouldUpdate() {
        UserDto dto = getDefaultUser();
        UserDto savedUser = userService.create(dto);
        assertNotNull(savedUser);

        savedUser.setUsername("New username");

        userService.update(savedUser);

        UserDto actual = userService.get(savedUser.getId());
        assertAll("User deleted",
                () -> assertEquals(savedUser.getUsername(), actual.getUsername()));

    }

    private UserDto getDefaultUser() {
        UserDto userDto = new UserDto();

        userDto.setUsername("Username");
        userDto.setFirstName("FirstName");
        userDto.setLastName("LastName");
        userDto.setPhone("123456789");
        userDto.setEmail("mail@mail.ru");
        return userDto;
    }

}