package com.example.leftover_rescue.SERVICE;

import com.example.leftover_rescue.MODEL.User;
import com.example.leftover_rescue.REPOSITORY.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for managing users.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Registers a new user.
     *
     * @param user The user to register.
     * @return A message indicating the result of the registration.
     */
    public String registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Email already exists!";
        }
        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    /**
     * Validates login credentials.
     *
     * @param email The user's email.
     * @param password The user's password.
     * @return True if credentials are valid, else false.
     */
    public boolean validateLogin(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }

    /**
     * Validates user credentials.
     *
     * @param email The user's email.
     * @param password The user's password.
     * @return True if credentials are valid, else false.
     */
    public boolean validateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false; // User not found
        }
        // Check if the provided password matches the hashed password
        return passwordEncoder.matches(password, user.getPassword());
    }
}
