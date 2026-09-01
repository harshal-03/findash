package com.findash_backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.findash_backend.user.UserRepository;
import com.findash_backend.user.User;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    // instead we are using Lombok annotation @RequiredArgsConstructor
    // public UserService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {
    //     this.userRepository = userRepository;
    //     this.passwordEncoder = passwordEncoder;
    // }


    /*
     *Record accessors don't use get prefix — Since RegisterRequest is a record,
     * the methods are request.email(), request.password(), request.name() —
     * NOT request.getEmail() etc.
    */
    public User registerUser(RegisterRequest request) {
        if(userRepository.existsByEmail(request.email())){
            throw new IllegalArgumentException("User already exists");
        }

        User user = new User();
        user.setEmail(request.email());
        user.setName(request.name());
        user.setPasswordHash(passwordEncoder.encode(request.password()));

        userRepository.save(user);

        return user;
    }
    
}
