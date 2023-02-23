package com.example.intermove.Services.EventsAndComplaints;

import com.example.intermove.Entities.EventsAndComplaints.Claim;
import com.example.intermove.Entities.User.User;
import com.example.intermove.Repositories.EventsAndComplaints.ClaimRepository;
import com.example.intermove.Repositories.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service

public class ClaimService implements IClaimService{
    @Autowired
    ClaimRepository claimRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private JavaMailSender mailSender;
  @Override
  public Claim addClaim(Claim claim , Long id) {
      User e = userRepository.findById(id).orElse(null);
     e.getComplaints().add(claim);
     claim.setUser(e);
      return claimRepository.save(claim);
         }
    @Override
    public Claim findById(Integer id) {
        return claimRepository.findById(id).get() ;
    }


    @Override
    public List<Claim> getAllComplaints() {
        return (List<Claim>) claimRepository.findAll();
    }

    @Override
    public Claim getComplaintsById(Integer id) {
        return claimRepository.findById(id).get();
    }

    @Override
    public void deleteComplaints(Integer id) {
        claimRepository.deleteById(id);

    }
    @Override
    public List<Claim> findAll() {
        return   claimRepository.findAll() ;
    }




    @Override
        public Claim UpdateClaim(Claim E, Integer id) {
        E.setId(id);
        return claimRepository.save(E);     }

    @Override
    public List<Claim> getClaimsByStatus(Boolean status) {
        return claimRepository.findByStatus(status);
    }




    @Override

    public void updateStatus(int id, boolean newValue) {
        // Recherche de l'objet MyClass correspondant à l'identifiant "id"
        Claim myObject = claimRepository.findById(id).orElse(null);

        // Vérification que l'objet a été trouvé
        if (myObject != null) {
            // Modification de la propriété "property2"
            myObject.setStatus(newValue);
            claimRepository.save(myObject);
        }


}

    @Override
    public List<MostComplainer> mostComplainer() {
        return claimRepository.mostComplainer();

    }

    @Override
    public List<DuplicateComplainers> duplicateComplainers() {

            return claimRepository.getDuplicateComplainers();

    }
    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("lyna.khaznaji@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send...");
    }


}

