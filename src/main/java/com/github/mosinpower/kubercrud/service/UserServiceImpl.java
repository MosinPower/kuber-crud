package com.github.mosinpower.kubercrud.service;

import com.github.mosinpower.kubercrud.dto.UserDto;
import com.github.mosinpower.kubercrud.entity.User;
import com.github.mosinpower.kubercrud.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDto create(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        if (userDto.getId() != null) {
            Optional<User> userOptional = userRepository.findById(userDto.getId());
            if (userOptional.isPresent()) {
                return null;
            }
        }
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto get(Long userId) {
        return userRepository.findById(userId)
                .map(UserMapper::toDto)
                .orElse(null);
    }

    @Override
    public boolean update(UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLastName(userDto.getLastName());
            user.setFirstName(userDto.getFirstName());
            user.setEmail(userDto.getEmail());
            user.setUsername(userDto.getUsername());
            user.setPhone(userDto.getPhone());
            userRepository.save(user);
            return true;
        }
        return false;
    }
}

class UserMapper {

    static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    static User toEntity(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        return user;
    }
}
