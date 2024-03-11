package com.groupeisi.ecommercegraphql.service.impl;

import com.groupeisi.ecommercegraphql.dto.UserDto;
import com.groupeisi.ecommercegraphql.entities.User;
import com.groupeisi.ecommercegraphql.mappers.UserMapper;
import com.groupeisi.ecommercegraphql.repository.UserRepository;
import com.groupeisi.ecommercegraphql.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public void save(UserDto userDto) {
       this.userRepository.save(userMapper.toUserEntity(userDto));
    }
    @Override
    public void saveUserEntity(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toUserDto);
    }
}
