package com.example.intermove.Repositories;

import com.example.intermove.Entities.Offer.OfferHistory;
import com.example.intermove.Entities.Offer.OfferInteressant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOffreHistoryRepo extends JpaRepository<OfferHistory, Integer> {
}
