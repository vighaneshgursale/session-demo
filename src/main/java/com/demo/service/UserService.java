package com.demo.service;

import com.demo.dto.UserDto;
import com.demo.exception.UserAlreadyExistsException;
import com.demo.model.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder userPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userPasswordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerUser(UserDto userDto) throws UserAlreadyExistsException {
        Optional<User> userOptional = userRepository.findByUsernameAndActive(userDto.getUsername(), true);
        if(!userOptional.isPresent()) {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(userPasswordEncoder.encode(userDto.getPassword()));
            user.setName(userDto.getName());
            user.setContact(userDto.getContact());
            return userRepository.save(user);
        }
        else
            throw new UserAlreadyExistsException(userDto.getUsername());
    }
}
