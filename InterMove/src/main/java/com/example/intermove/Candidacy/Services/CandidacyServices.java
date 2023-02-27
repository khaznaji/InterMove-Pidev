package com.example.intermove.Candidacy.Services;

import com.example.intermove.Candidacy.Repository.ICandidacyRepository;
import com.example.intermove.Entities.CandidatesAndCourses.Candidacy;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidacyServices implements ICandidacyServices {

    @Autowired
    ICandidacyRepository candidacyRepository;
    @Override
    public Candidacy addCandidacy(Candidacy candidacy) {
        return candidacyRepository.save(candidacy);
    }
}
