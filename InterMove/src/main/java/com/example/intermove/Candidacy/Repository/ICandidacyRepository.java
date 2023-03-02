package com.example.intermove.Candidacy.Repository;

import com.example.intermove.Entities.CandidatesAndCourses.Candidacy;
import com.example.intermove.Entities.CandidatesAndCourses.CandidacyStatus;
import com.example.intermove.Entities.Offer.Offer;
import com.example.intermove.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ICandidacyRepository extends JpaRepository<Candidacy, Integer> {

    List<Candidacy> findByUser(User user);

    List<Candidacy> findByOffer(Offer offer);

    List<Candidacy> findByStatus(CandidacyStatus status);

    List<Candidacy> findByDateCandidacyAfter(Date date);

    List<Candidacy> findByUserAndDateCandidacyAfter(User user, Date date);

    List<Candidacy> findByOfferAndDateCandidacyAfter(Offer offer, Date date);

    Candidacy findByUserAndOffer(User user, Offer offer);

}
