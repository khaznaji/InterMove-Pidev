package com.example.intermove.Services.UserService;

import com.example.intermove.Entities.User.User;
import com.example.intermove.Repositories.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;


}
