package com.example.intermove.Controllers.EventsAndComplaints;

import com.example.intermove.Entities.EventsAndComplaints.Events;
import com.example.intermove.Entities.EventsAndComplaints.ModaliteEvent;
import com.example.intermove.Entities.EventsAndComplaints.TypeEvent;
import com.example.intermove.Entities.User.User;
import com.example.intermove.Repositories.EventsAndComplaints.EventRepository;
import com.example.intermove.Services.EventsAndComplaints.EventService;
import com.example.intermove.Services.Files.FileStorageService;
import com.example.intermove.Services.UserService.UserService;
import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Events")
public class EventsController {
    @Autowired
    private EventService service;
    @Autowired
    FileStorageService fileStorageService ;
    @Autowired
    private UserService userService;

    @PostMapping("/add")

    public ResponseEntity<String> saveEvnets(@RequestParam("title") String title, @RequestParam ("description") String desc,
                                             @RequestParam ("dateD") Date dateD, @RequestParam ("dateF") Date dateF,
                                             @RequestParam ("nbPlace") int  nbP, @RequestParam ("Speaker") String  Speaker,
                                             @RequestParam ("typeEvent") TypeEvent typeEvent, @RequestParam ("modaliteEvent") ModaliteEvent modaliteEvent
                                             , @RequestParam("upload") MultipartFile upload  )
    {
        Events events = new Events() ;
        events.setTitle(title);
        events.setDescription(desc);
        events.setDateD(dateD);
        events.setDateF(dateF);
        events.setSpeaker(Speaker);
        events.setTypeEvent(typeEvent);
        events.setModaliteEvent(modaliteEvent);
        events.setNbreDePlaces(nbP);
        events.setImage(fileStorageService.storeFile(upload));
        Integer id = service.saveEvents(events);
        return new ResponseEntity<String>("events with " +id+ "has been saved", HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Events>> getAllEventsdetails()
    {
        List<Events> list=service.getAllEvents();
        return new ResponseEntity<List<Events>>(list,HttpStatus.OK);
    }


    @PutMapping ("/updateEvents/{id}")
        public Events UpdateEvents( @PathVariable Integer id, @RequestParam("title") String title,
                                    @RequestParam ("description") String desc, @RequestParam ("dateD") Date dateD,
                                    @RequestParam ("dateF") Date dateF , @RequestParam ("nbPlace") int  nbP,
                                    @RequestParam ("Speaker") String  Speaker, @RequestParam ("typeEvent") TypeEvent typeEvent,
                                    @RequestParam ("modaliteEvent") ModaliteEvent modaliteEvent, @RequestParam("upload") MultipartFile upload){
        Events events = new Events() ;
        events.setTitle(title);
        events.setDescription(desc);
        events.setDateD(dateD);
        events.setDateF(dateF);
        events.setSpeaker(Speaker);
        events.setTypeEvent(typeEvent);
        events.setModaliteEvent(modaliteEvent);
        events.setNbreDePlaces(nbP);
        events.setImage(fileStorageService.storeFile(upload));
        return service.UpdateEvent(events, id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.deleteEvent(id);
    }
    @GetMapping("/getEventsbyid/{id}")
    public ResponseEntity<Events> getEventsById(@PathVariable("id") Integer id)
    {
        Events ev= service.getEventsById(id);
        return new ResponseEntity<Events>(ev,HttpStatus.OK);

    }
    @GetMapping("/getEventsbyTitle/{title}")
    public List<Events> getEventsbyTitle(@PathVariable("title")String title) {
        return service.findByTitle(title);
    }

    @PostMapping (value="/affecter-user-event/{id}/{idE}")
    public ResponseEntity<String> affecterUserToEvent(@PathVariable("id") Long id, @PathVariable("idE")Integer idE) {

       // service.AssignUserToEvent(id, idE);

        try {
            service.assignUserToEvent(id, idE);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    }


