package com.example.intermove.Candidacy.Controller;

import com.example.intermove.Candidacy.Services.EmailService;
import com.example.intermove.Entities.CandidatesAndCourses.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody Email emailDto) throws MessagingException {
        String to = emailDto.getTo();
        String subject = emailDto.getSubject();
        String body = emailDto.getBody();
        emailService.sendEmail(to, subject, body);
        return ResponseEntity.ok("Email sent successfully.");
    }
}
