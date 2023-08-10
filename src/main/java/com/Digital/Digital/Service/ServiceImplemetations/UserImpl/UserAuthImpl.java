package com.Digital.Digital.Service.ServiceImplemetations.UserImpl;

import com.Digital.Digital.Entity.User.UserAuth;
import com.Digital.Digital.Infrastructure.Dto.UserDto.UserAuthDto;
import com.Digital.Digital.Repository.UserRepository.UserJWTRepository;
import com.Digital.Digital.Service.UserService.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserAuthImpl implements UserAuthService {
    @Autowired
    private UserJWTRepository userRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public void register(UserAuthDto userDto) throws Exception {
        UserAuth user = new UserAuth();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }
}