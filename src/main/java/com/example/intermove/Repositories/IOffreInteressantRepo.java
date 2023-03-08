package com.example.intermove.Repositories;

import com.example.intermove.Entities.Offer.Offer;
import com.example.intermove.Entities.Offer.OfferInteressant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOffreInteressantRepo extends JpaRepository<OfferInteressant, Integer> {
   // List<OfferInteressant> findByinteresseTrue();


}
