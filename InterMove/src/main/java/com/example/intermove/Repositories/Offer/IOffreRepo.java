package com.example.intermove.Repositories.Offer;

import com.example.intermove.Entities.Offer.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface IOffreRepo extends JpaRepository<Offer, Integer> {

    @Query("Select dc From Offer dc where dc.historique = true ")
    List<Offer> findByHistorique1();

    @Query("Select dc From Offer dc where dc.datefin < current_date ")
    List<Offer> listeroffres();

    List<Offer> findByHistorique(Boolean historique);

    @Query("SELECT count(c) FROM Offer c where ((c.historique=true) and  ((c.datedebut BETWEEN :startDate AND :endDate)) or(c.datefin BETWEEN :startDate AND :endDate))")
    public Integer getnboffresexist(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

   // List<Offer> findByinteresseTrue();

    List<Offer> findByinteresseTrue();

}
