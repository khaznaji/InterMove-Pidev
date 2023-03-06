package com.example.security.service;


import com.example.security.domain.User;
import com.example.security.security.RegisterRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IUserService {

     User addUser (User user);
     List<User> retrieveAllUsers();

     User retrieveUserById(Integer userid);

     void deleteUser(Integer userid);

     User updateUser(User user);
     public User findById(int id );
     User forgetPassword(String email);


     String saveImage(MultipartFile image, User request) throws IOException;
}
