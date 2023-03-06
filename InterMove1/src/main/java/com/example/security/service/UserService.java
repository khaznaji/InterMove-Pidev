package com.example.security.service;


import com.example.security.domain.User;
import com.example.security.repos.IUserRepository;

import com.example.security.security.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User addUser(User resquest) {
        return userRepository.save(resquest);
    }
    @Override
    public List<User> retrieveAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User retrieveUserById(Integer userid){
        return userRepository.findById(userid).orElse(null);
    }

    @Override
    public void deleteUser(Integer userid){
        User u= retrieveUserById(userid);
        userRepository.delete(u);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("iheb.benothmen@esprit.tn");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send...");
    }

    private User getUserByEmail(String email) {

        Session session = sessionFactory.openSession();
        Query q = session.createQuery("select login from User login where login.email=:email");
        q.setString("email", email);
        User userObj = (User) q.uniqueResult();
        session.close();
        return userObj;
    }
    public User forgetPassword(String email) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = (User) session.load(User.class, getUserByEmail(email).getId());
        if (user != null) {
            user.setPassword(UUID.randomUUID() + "");
            session.update(user);
            tx.commit();

        }


        return user;
    }

    @Override
    public String saveImage(MultipartFile image, User request)throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        Path path = Paths.get("uploads");
        Files.createDirectories(path);
        try (InputStream inputStream = image.getInputStream()) {
            Path filePath = path.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            request.setProfilepicture(filePath.toString());
            return filePath.toString();
        } catch (IOException e) {
            throw new IOException("Could not save file " + fileName, e);
        }

    }


}

