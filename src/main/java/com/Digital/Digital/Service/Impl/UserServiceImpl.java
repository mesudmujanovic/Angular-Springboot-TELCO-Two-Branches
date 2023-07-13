package com.Digital.Digital.Service.Impl;

import com.Digital.Digital.Entity.User;
import com.Digital.Digital.Infrastructure.Dto.UserDto;
import com.Digital.Digital.Repository.UserRepository;
import com.Digital.Digital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public void register(UserDto userDto) throws Exception {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }
}