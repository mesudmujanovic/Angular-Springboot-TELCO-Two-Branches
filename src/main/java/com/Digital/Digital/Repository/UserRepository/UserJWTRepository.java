package com.Digital.Digital.Repository.UserRepository;


import com.Digital.Digital.Entity.User.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJWTRepository extends JpaRepository<UserAuth, Long> {
    UserAuth findByUsername(String username);
}
