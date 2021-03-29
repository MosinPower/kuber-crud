package com.github.mosinpower.kubercrud.service;

import com.github.mosinpower.kubercrud.dto.UserDto;

public interface UserService {
    UserDto create(UserDto userDto);

    void delete(Long userId);

    UserDto get(Long userId);

    boolean update(UserDto userDto);
}
