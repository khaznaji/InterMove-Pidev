package com.example.intermove.Services.EventsAndComplaints;

import com.example.intermove.Entities.User.User;
import com.example.intermove.Repositories.EventsAndComplaints.EventRepository;
import com.example.intermove.Repositories.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.intermove.Entities.EventsAndComplaints.Events;

import java.util.List;
import java.util.Optional;

@Service

public class EventService implements IEventsService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Integer saveEvents(Events event) {return eventRepository.save(event).getId();}

    @Override
    public List<Events> getAllEvents() {
        return (List<Events>) eventRepository.findAll();
    }



    @Override
    public Events getEventsById(Integer id) {
        return eventRepository.findById(id).get();    }

    @Override
    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Events UpdateEvent(Events E, Integer id) {
        E.setId(id);
        return eventRepository.save(E);    }

    @Override
    public List<Events> findByTitle(String title) {
        return eventRepository.findByTitle(title);    }


   // public void AssignUserToEvent(Long id, Integer idE) {
    //    User user = userRepository.findById(id).orElse(null);
      //  Events events = eventRepository.findById(idE).orElse(null);
        //user.setEvents(events);
        //userRepository.save(user);
   // }
    @Override

    public void assignUserToEvent(Long userId, Integer eventId) throws Exception {
        Optional<Events> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Events event = optionalEvent.get();
            if (event.getNbreDePlaces() > 0) {
                // Decrement available participants and save event
                event.setNbreDePlaces(event.getNbreDePlaces()- 1);
                User user = userRepository.findById(userId).orElse(null);
                Events events = eventRepository.findById(eventId).orElse(null);
                user.setEvents(events);
                userRepository.save(user);

                // Assign user to event (not implemented here)
            } else {
                throw new Exception("Event is full");
            }
        } else {
            throw new Exception("Event not found");
        }
    }



}

