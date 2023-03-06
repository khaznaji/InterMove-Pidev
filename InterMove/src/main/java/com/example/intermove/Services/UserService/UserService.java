package com.example.intermove.Services.UserService;

import com.example.intermove.Entities.User.User;
import com.example.intermove.Repositories.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public String getUserTelById(Long id) {
        User user = getUserById(id);
        return user.getTel();
    }
}
