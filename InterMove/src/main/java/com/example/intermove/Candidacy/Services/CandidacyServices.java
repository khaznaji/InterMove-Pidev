package com.example.intermove.Candidacy.Services;

import com.example.intermove.Candidacy.Repository.ICandidacyRepository;
import com.example.intermove.Entities.CandidatesAndCourses.Candidacy;
import com.example.intermove.Entities.CandidatesAndCourses.CandidacyStatus;
import com.example.intermove.Entities.Offer.Offer;
import com.example.intermove.Entities.User.User;
import com.example.intermove.Forum.Controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CandidacyServices implements ICandidacyServices {

    @Autowired
    private ICandidacyRepository candidacyRepository;


//    @Override
//    public Candidacy addCandidacy(Candidacy candidacy) {
//        return candidacyRepository.save(candidacy);    }

    @Override
    public Candidacy createCandidature(Candidacy candidature) {
        return candidacyRepository.save(candidature);
    }
   @Override
   public Candidacy updateCandidacy(Integer id, Candidacy candidacyDetails) {
       Candidacy candidacy = candidacyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Candidacy", "id", id));

       candidacy.setFirstName(candidacyDetails.getFirstName());
       candidacy.setLastName(candidacyDetails.getLastName());
       candidacy.setEmail(candidacyDetails.getEmail());
       candidacy.setPhoneNumber(candidacyDetails.getPhoneNumber());
       candidacy.setStatus(candidacyDetails.getStatus());
       candidacy.setOffer(candidacyDetails.getOffer());
       candidacy.setUser(candidacyDetails.getUser());
       candidacy.setDocuments(candidacyDetails.getDocuments());

       return candidacyRepository.save(candidacy);
   }
    @Override
    public Candidacy updateCandidature(Candidacy candidature) {
        return null;
    }

    @Override
    public void deleteCandidature(int id) {

    }
    @Override
    public List<Candidacy> getAllCandidacies() {
        return candidacyRepository.findAll();
    }

    @Override
    public Candidacy getCandidatureById(int id) {
        return candidacyRepository.findById(id).orElse(null);
    }
//    @Override
//    public Candidacy getCandidatureById(int id) {
//        return candidacyRepository.findById(id);
//    }

    @Override
    public List<Candidacy> getCandidaturesByUser(User user) {
        return null;
    }

    @Override
    public List<Candidacy> getCandidaturesByOffer(Offer offer) {
        return null;
    }

    @Override
    public List<Candidacy> getCandidaturesByStatus(CandidacyStatus status) {
        return null;
    }

    @Override
    public List<Candidacy> getCandidaturesSubmittedAfterDate(Date date) {
        return null;
    }

    @Override
    public List<Candidacy> getCandidaturesSubmittedByUserAfterDate(User user, Date date) {
        return null;
    }

    @Override
    public List<Candidacy> getCandidaturesSubmittedForOfferAfterDate(Offer offer, Date date) {
        return null;
    }

    @Override
    public Candidacy getCandidatureByUserAndOffer(User user, Offer offer) {
        return null;
    }

    @Override
    public void acceptCandidature(Candidacy candidature) {

    }

    @Override
    public void rejectCandidature(Candidacy candidature) {

    }

    @Override
    public void updateCandidatureStatus(Candidacy candidature, CandidacyStatus status) {

    }
}
//    @Override
//    public Candidacy addCandidacy(Candidacy candidacy) {
//        return candidatureRepository.save(candidacy);
//    }
//
//
//
//
//    @Override
//    public Candidacy createCandidature(Candidacy candidature) {
//        // Set the dateCandidacy to the current system date
//       // Offer offer;
//
//      //  candidature.setOffer();
//        candidature.setDateCandidacy(new Date());
//        // Set the status to 'poor' by default
//        candidature.setStatus(CandidacyStatus.Poor);
//        return candidatureRepository.save(candidature);
//    }
//
//    @Override
//    public Candidacy updateCandidature(Candidacy candidature) {
//        // Update the dateCandidacy to the current system date
//        candidature.setDateCandidacy(new Date());
//        return candidatureRepository.save(candidature);
//    }
//
//    @Override
//    public void deleteCandidature(int idC) {
//        candidatureRepository.deleteById(idC);
//    }
//
//    @Override
//    public Candidacy getCandidatureById(int id) {
//        return candidatureRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Candidature", "id", id));
//    }
//
////    @Override
////    public List<Candidacy> getCandidaturesByUser(User user) {
////        return candidatureRepository.findByUser(user);
////    }
//
//    @Override
//    public List<Candidacy> getCandidaturesByOffer(Offer offer) {
//        return candidatureRepository.findByOffer(offer);
//    }
//
//    @Override
//    public List<Candidacy> getCandidaturesByStatus(CandidacyStatus status) {
//        return candidatureRepository.findByStatus(status);
//    }
//
//    @Override
//    public List<Candidacy> getCandidaturesSubmittedAfterDate(Date date) {
//        return candidatureRepository.findByDateCandidacyAfter(date);
//    }
//
////    @Override
////    public List<Candidacy> getCandidaturesSubmittedByUserAfterDate(User user, Date date) {
////        return candidatureRepository.findByUserAndDateCandidacyAfter(user, date);
////    }
//
//    @Override
//    public List<Candidacy> getCandidaturesSubmittedForOfferAfterDate(Offer offer, Date date) {
//        return candidatureRepository.findByOfferAndDateCandidacyAfter(offer, date);
//    }
//
////    @Override
////    public Candidacy getCandidatureByUserAndOffer(User user, Offer offer) {
////        return candidatureRepository.findByUserAndOffer(user, offer);
////    }
//
//    @Override
//    public void acceptCandidature(Candidacy candidature) {
//        // Set the status to 'good'
//        candidature.setStatus(CandidacyStatus.Good);
//        candidatureRepository.save(candidature);
//    }
//
//    @Override
//    public void rejectCandidature(Candidacy candidature) {
//        // Set the status to 'bad'
//        candidature.setStatus(CandidacyStatus.Bad);
//        candidatureRepository.save(candidature);
//    }
//
//    @Override
//    public void updateCandidatureStatus(Candidacy candidature, CandidacyStatus status) {
//        candidature.setStatus(status);
//        candidatureRepository.save(candidature);
//    }
//
//}

