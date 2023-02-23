package com.example.intermove.Services.EventsAndComplaints;

import com.example.intermove.Entities.EventsAndComplaints.Events;

import java.util.List;


public interface IEventsService {
    public Integer saveEvents(Events event);
    public List<Events> getAllEvents();


    public Events getEventsById(Integer id);
    public void deleteEvent(Integer id);
    Events UpdateEvent (Events E , Integer id);
    public List<Events> findByTitle(String title);
 //public void AssignUserToEvent (Long id , Integer idE);
    public void assignUserToEvent(Long userId, Integer eventId) throws Exception;}
