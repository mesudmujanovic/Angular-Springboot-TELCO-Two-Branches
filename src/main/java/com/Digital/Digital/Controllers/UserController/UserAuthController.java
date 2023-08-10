package com.Digital.Digital.Controllers.UserController;

import com.Digital.Digital.Infrastructure.Dto.UserDto.UserAuthDto;
import com.Digital.Digital.Infrastructure.Request.UserRequest.UserJwt.LoginRequest;
import com.Digital.Digital.Infrastructure.Request.UserRequest.UserJwt.SignupRequest;
import com.Digital.Digital.Infrastructure.Response.UserResponse.UserJwt.JwtResponse;
import com.Digital.Digital.Infrastructure.Response.UserResponse.UserJwt.MessageResponse;
import com.Digital.Digital.Security.Jwt.JwtUtils;
import com.Digital.Digital.Security.Services.UserDetailsImpl;
import com.Digital.Digital.Service.UserService.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserAuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserAuthService userService;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(),
                userDetails.getUsername()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        try {
            UserAuthDto userDto = UserAuthDto.fromRequest(signUpRequest);
            userService.register(userDto);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } catch (
                DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("An error occurred while registrering the user");
        }
    }
}