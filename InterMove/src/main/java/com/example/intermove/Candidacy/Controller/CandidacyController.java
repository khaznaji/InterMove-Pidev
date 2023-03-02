//package com.example.intermove.Candidacy.Controller;
//
//public class CandidacyController {
//}


package com.example.intermove.Candidacy.Controller;

        import com.example.intermove.Candidacy.Services.CandidacyServices;
        import com.example.intermove.Candidacy.Services.ICandidacyServices;
        import com.example.intermove.Entities.CandidatesAndCourses.Candidacy;
        import com.example.intermove.Entities.CandidatesAndCourses.CandidacyStatus;
        import com.example.intermove.Entities.Offer.Offer;
        import com.example.intermove.Entities.User.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.Date;
        import java.util.List;

@RestController
@RequestMapping("/candidacy")
public class CandidacyController {


        @Autowired
        ICandidacyServices candidacyService;

        @PostMapping("/create")
        public ResponseEntity<Candidacy> createCandidacy(@RequestBody Candidacy candidacy) {
                Candidacy createdCandidacy = candidacyService.createCandidature(candidacy);
                System.out.println(candidacy);
                return new ResponseEntity<>(createdCandidacy, HttpStatus.CREATED);
        }
        @GetMapping("/{id}")
        public Candidacy getCandidatureById(@PathVariable(value = "id") int id) {
        return candidacyService.getCandidatureById(id);
    }

        @GetMapping("/")
        public List<Candidacy> getAllCandidacies() {
                return candidacyService.getAllCandidacies();
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Candidacy> updateCandidacy(@PathVariable Integer id, @RequestBody Candidacy candidacy) {
                Candidacy updatedCandidacy = candidacyService.updateCandidacy(id, candidacy);
                return new ResponseEntity<>(updatedCandidacy, HttpStatus.OK);

        }
}


//     Create Candidacy
//    @PostMapping("/")
//    public Candidacy createCandidature(@RequestBody Candidacy candidature) {
//        return candidatureService.createCandidature(candidature);
//    }

//    // Update Candidacy
//    @PutMapping("/")
//    public Candidacy updateCandidature(@RequestBody Candidacy candidature) {
//        return candidatureService.updateCandidature(candidature);
//    }
//
//    // Delete Candidacy
//    @DeleteMapping("/{idC}")
//    public ResponseEntity<Candidacy> deleteCandidature(@PathVariable(value = "idC") int idC) {
//        candidatureService.deleteCandidature(idC);
//        return ResponseEntity.ok().build();
//    }
//
//    // Get Candidacy by ID
//    @GetMapping("/{id}")
//    public Candidacy getCandidatureById(@PathVariable(value = "id") int id) {
//        return candidatureService.getCandidatureById(id);
//    }
//
//    // Get Candidacies by User
////   @GetMapping("/user/{userId}")
////    public List<Candidacy> getCandidaturesByUser(@PathVariable(value = "userId") int userId) {
////        User user = new User();
////        user.setId(userId);
////        return candidatureService.getCandidaturesByUser(user);
////    }
//
//    // Get Candidacies by Offer
//    @GetMapping("/offer/{offerId}")
//    public List<Candidacy> getCandidaturesByOffer(@PathVariable(value = "offerId") int offerId) {
//        Offer offer = new Offer();
//        offer.setIdoffre(offerId);
//        return candidatureService.getCandidaturesByOffer(offer);
//    }
//
//    // Get Candidacies by Status
//    @GetMapping("/status/{status}")
//    public List<Candidacy> getCandidaturesByStatus(@PathVariable(value = "status") CandidacyStatus status) {
//        return candidatureService.getCandidaturesByStatus(status);
//    }
//
//    // Get Candidacies submitted after date
//    @GetMapping("/date/{date}")
//    public List<Candidacy> getCandidaturesSubmittedAfterDate(@PathVariable(value = "date") Date date) {
//        return candidatureService.getCandidaturesSubmittedAfterDate(date);
//    }
//
//    // Get Candidacies submitted by user after date
////    @GetMapping("/user/{userId}/date/{date}")
////    public List<Candidacy> getCandidaturesSubmittedByUserAfterDate(@PathVariable(value = "userId") int userId,
////                                                                   @PathVariable(value = "date") Date date) {
////        User user = new User();
////        user.setId(userId);
////        return candidatureService.getCandidaturesSubmittedByUserAfterDate(user, date);
////    }
//
//    // Get Candidacies submitted for offer after date
//    @GetMapping("/offer/{offerId}/date/{date}")
//    public List<Candidacy> getCandidaturesSubmittedForOfferAfterDate(@PathVariable(value = "offerId") int offerId,
//                                                                     @PathVariable(value = "date") Date date) {
//        Offer offer = new Offer();
//        offer.setIdoffre(offerId);
//        return candidatureService.getCandidaturesSubmittedForOfferAfterDate(offer, date);
//    }
//
////  /*  // Accept Candidacy
////    @PostMapping("/{id}/accept")
////    public ResponseEntity<?>
