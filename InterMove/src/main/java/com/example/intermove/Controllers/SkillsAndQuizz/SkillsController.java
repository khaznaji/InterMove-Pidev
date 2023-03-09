
package com.example.intermove.Controllers.SkillsAndQuizz;

import com.example.intermove.Entities.Domain;
import com.example.intermove.Entities.SkillsAndQuizz.Quiz;
import com.example.intermove.Entities.SkillsAndQuizz.SkillDTO;
import com.example.intermove.Entities.SkillsAndQuizz.Skills;
import com.example.intermove.Entities.User.User;
import com.example.intermove.Services.SkillsAndQuizz.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/gestionSkills")

public class SkillsController {

    @Autowired
    SkillsService skillsService;


    @PostMapping("/addSkillsToUser/{id}")
    public void addSkillsToUser(@RequestParam("domain") Domain domain,
                                @RequestParam("description") String desc, @RequestParam("quiz") Quiz quiz, @PathVariable int id){
        Skills s = new Skills();
        s.setDomain(domain);
        s.setDescription(desc);

        s.setQuiz(quiz);
        skillsService.addSkillsToUser(s, id);

    }


    @GetMapping("/retrieve-all-Skills")
    public List<SkillDTO> getEtudiants() {
    return skillsService.findSkillsWithUserAndQuizzNames();
    }


    @DeleteMapping("/remove-Skills/{id}")
    public void removeOffre(@PathVariable("id") Integer id) {
        skillsService.removeSkills(id);
    }

//    @PutMapping ("/updateSkills/{id}")
//    public Skills updateSkills ( @PathVariable int id,@RequestParam ("description") String description,
//                                 @RequestParam ("domain") Domain domain,@RequestParam("User") User id)
//    {
//        Skills s = new Skills() ;
//
//
//
//
//        s.setDescription(description);
//
//        s.setDomain(domain);
//        return skillsService.updateSkills(s, id);
//
//    }

    @PutMapping("/updateSkills/{id}")
    public void updateSkills(
            @RequestParam("domain") Domain domain,
            @RequestParam("description") String desc, @RequestParam("quiz") Quiz quiz, @RequestParam("user") User user, @PathVariable Integer id){
            Skills s = new Skills();
            s.setDomain(domain);
            s.setDescription(desc);
            s.setUser(user);
            s.setQuiz(quiz);
        skillsService.updateSkills(s,id);
    }


    @GetMapping("/SearchSkills/{description}")
    @ResponseBody
    List<Skills> searchSkills(@PathVariable("description") String description) {
        return skillsService.searchSkills(description);
    }
}
