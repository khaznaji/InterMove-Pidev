package com.example.intermove.Services.Offer;

import com.example.intermove.Entities.Offer.Offer;
import com.example.intermove.Entities.Offer.OfferHistory;
import com.example.intermove.Entities.Offer.OfferInteressant;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface IOffreService {
    public Offer ajouteroffre(Offer off);
    public List<Offer> retrieveAllOffres();
    public Offer updateOffre1(Offer o, Integer idoffre) ;
    public Offer retrieveOffre(Integer  idoffre);

    public void removeOffre(Integer idoffre);

    List<Offer> findByHistorique1();

    List<Offer> listeroffres();

    public List<Offer> getOffreByHistorique(Boolean historique);

    public 	Integer nboffresexist(Date startDate, Date endDate);

    public void markOfferAsInteressant(Integer idoffre);
   // public List<Offer> listeroffresdto();

    public OfferInteressant retrieveOffreintersss(int id);
    public void removeOffreinterss(int id);

    public void exportcontrat(  int idoffre, String filePath) throws IOException;
    public void markOfferAsHistory(Integer idoffre);
    public OfferHistory retrieveOffreHistory(int id);
    //public void markHistoryAsOffer(Integer idoffre);

    public List<Offer> getinteresseOffers();

}
